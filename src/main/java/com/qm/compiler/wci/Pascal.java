package com.qm.compiler.wci;

import com.qm.compiler.wci.backend.Backend;
import com.qm.compiler.wci.backend.BackendFactory;
import com.qm.compiler.wci.frontend.FrontendFactory;
import com.qm.compiler.wci.frontend.Parser;
import com.qm.compiler.wci.frontend.Source;
import com.qm.compiler.wci.intermediate.ICode;
import com.qm.compiler.wci.intermediate.SymTab;
import com.qm.compiler.wci.message.Message;
import com.qm.compiler.wci.message.MessageListener;
import com.qm.compiler.wci.message.MessageType;

import java.io.BufferedReader;
import java.io.FileReader;


/**
 * 
 * Pascal外壳程序，根据参数选择性的调用编译器或者解释器
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class Pascal
{
    private Parser  parser;    // 语言无关的 parser
    private Source  source;    // 语言无关的 scanner
    private ICode   iCode;      // 抽象语法树
    private SymTab  symTab;    // 符号表
    private Backend backend;  // 后端

    /**
     * 编译或者解释源程序
     * @param operation compile 或者 execute
     * @param filePath 源文件路径
     * @param flags 命令行参数标记
     */
    public Pascal(String operation, String filePath, String flags)
    {
        try {
        	//显示中间码结构
            boolean intermediate = flags.indexOf('i') > -1;
            //显示符号引用
            boolean xref         = flags.indexOf('x') > -1;

            source = new Source(new BufferedReader(new FileReader(filePath)));
            source.addMessageListener(new SourceMessageListener());
            //top-down是Parser的一种，还有一种本书没有实现的bottom-up。
            parser = FrontendFactory.createParser("Pascal", "top-down", source);
            parser.addMessageListener(new ParserMessageListener());

            backend = BackendFactory.createBackend(operation);
            backend.addMessageListener(new BackendMessageListener());

            parser.parse();
            source.close();
			//生成中间码和符号表
            iCode = parser.getICode();
            symTab = parser.getSymTab();
            //交由后端处理
            backend.process(iCode, symTab);
        }
        catch (Exception ex) {
            System.out.println("***** 翻译器出现错误 *****");
            ex.printStackTrace();
        }
    }

    private static final String FLAGS = "[-ix]";
    private static final String USAGE =
        "使用方式: Pascal execute|compile " + FLAGS + " <源文件路径>";

    /**
     * 入口程序，参考Pascal构造函数的参数接受过程。<br>
     * 例如：compile -i hello.pas 
     */
    public static void main(String args[])
    {
        try {
            String operation = args[0];

            // 翻译操作类型，compile或execute
            if (!(   operation.equalsIgnoreCase("compile")
                  || operation.equalsIgnoreCase("execute"))) {
                throw new Exception();
            }

            int i = 0;
            String flags = "";

            // 参数标识
            while ((++i < args.length) && (args[i].charAt(0) == '-')) {
                flags += args[i].substring(1);
            }

            // 源文件
            if (i < args.length) {
                String path = args[i];
                new Pascal(operation, path, flags);
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception ex) {
            System.out.println(USAGE);
        }
    }

    private static final String SOURCE_LINE_FORMAT = "%03d %s";

    /**
     * 源（也就是源文件)的监听器，用于监听源文件的读取情况，如果注册了监听器，源每产生一条消息比如<br>
     * 读取了一行等，将会调用相应的监听器处理。典型的Observe模式
     */
    private class SourceMessageListener implements MessageListener
    {
        public void messageReceived(Message message)
        {
            MessageType type = message.getType();
            Object body[] = (Object []) message.getBody();

            switch (type) {
            	//源读取了一行
                case SOURCE_LINE: {
                    int lineNumber = (Integer) body[0];
                    String lineText = (String) body[1];

                    System.out.println(String.format(SOURCE_LINE_FORMAT,
                                                     lineNumber, lineText));
                    break;
                }
            }
        }
    }

    private static final String PARSER_SUMMARY_FORMAT =
        "源文件共有\t%d行。" +
        "\n有\t%d个语法错误." +
        "\n解析共耗费\t%.2f秒.\n";

    /**
     * Parser的监听器，监听来自Parser解析过程中产生的消息，还是Observe模式
     */
    private class ParserMessageListener implements MessageListener
    {
        public void messageReceived(Message message)
        {
            MessageType type = message.getType();

            switch (type) {

                case PARSER_SUMMARY: {
                    Number body[] = (Number[]) message.getBody();
                    int statementCount = (Integer) body[0];
                    int syntaxErrors = (Integer) body[1];
                    float elapsedTime = (Float) body[2];
                    System.out.println("\n----------代码解析统计信--------------");
                    System.out.printf(PARSER_SUMMARY_FORMAT,
                                      statementCount, syntaxErrors,
                                      elapsedTime);
                    break;
                }
            }
        }
    }

    private static final String INTERPRETER_SUMMARY_FORMAT =
        "共执行\t%d 条语句。" +
        "\n运行中发生了\t%d 个错误。" +
        "\n执行共耗费\t%.2f 秒。\n";

    private static final String COMPILER_SUMMARY_FORMAT =
        "共生成\t\t%d 条指令" +
        "\n代码生成共耗费\t%.2f秒\n";

    private class BackendMessageListener implements MessageListener
    {
        public void messageReceived(Message message)
        {
            MessageType type = message.getType();

            switch (type) {

                case INTERPRETER_SUMMARY: {
                    Number body[] = (Number[]) message.getBody();
                    int executionCount = (Integer) body[0];
                    int runtimeErrors = (Integer) body[1];
                    float elapsedTime = (Float) body[2];
                    System.out.println("\n----------解释统计信息------------");
                    System.out.printf(INTERPRETER_SUMMARY_FORMAT,
                                      executionCount, runtimeErrors,
                                      elapsedTime);
                    break;
                }

                case COMPILER_SUMMARY: {
                    Number body[] = (Number[]) message.getBody();
                    int instructionCount = (Integer) body[0];
                    float elapsedTime = (Float) body[1];
                    System.out.println("\n----------编译统计信--------------");
                    System.out.printf(COMPILER_SUMMARY_FORMAT,
                                      instructionCount, elapsedTime);
                    break;
                }
            }
        }
    }
}
