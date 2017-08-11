package com.qm.compiler.wci.frontend;


import com.qm.compiler.wci.intermediate.ICode;
import com.qm.compiler.wci.intermediate.SymTab;
import com.qm.compiler.wci.message.Message;
import com.qm.compiler.wci.message.MessageHandler;
import com.qm.compiler.wci.message.MessageListener;
import com.qm.compiler.wci.message.MessageProducer;

/**
 * <h1>Parser</h1>
 * <p>
 * <p>语言无关的Parser，有子类完成具体语言解析</p>
 * <p>
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public abstract class Parser implements MessageProducer {
    protected static SymTab         symTab         = null;                  // 生成的符号表
    // 代理消息处理类
    protected static MessageHandler messageHandler = new MessageHandler();

    protected final Scanner scanner;  // 扫描器SCANNER，Parser找它要token
    protected       ICode   iCode;      // 语法树根节点。

    protected Parser(Scanner scanner) {
        this.scanner = scanner;
        this.iCode = null;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public ICode getICode() {
        return iCode;
    }

    public SymTab getSymTab() {
        return symTab;
    }

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    /**
     * 交由子类完成具体语言相关的解析过程，这个方法调用之后将会产生符号表和中间码iCode。
     *
     * @throws Exception
     */
    public abstract void parse()
            throws Exception;

    /**
     * @return 解析过程中的错误数
     */
    public abstract int getErrorCount();

    public Token currentToken() {
        return scanner.currentToken();
    }

    public Token nextToken()
            throws Exception {
        return scanner.nextToken();
    }

    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}
