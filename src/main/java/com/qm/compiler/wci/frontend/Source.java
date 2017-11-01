package com.qm.compiler.wci.frontend;


import com.qm.compiler.wci.message.Message;
import com.qm.compiler.wci.message.MessageHandler;
import com.qm.compiler.wci.message.MessageListener;
import com.qm.compiler.wci.message.MessageProducer;

import java.io.BufferedReader;
import java.io.IOException;

import static com.qm.compiler.wci.message.MessageType.SOURCE_LINE;


/**
 * <h1>Source(源)</h1>
 *
 * <p>此框架类的每个对象代表一个源文件</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class Source implements MessageProducer
{
	// 行结束符，注意在Windows平台上，默认行结束符是\r\n，如果用记事本之类的写的pascal源程序，可以使用Ultraedit之类的给转成Unix格式的。
    public static final char EOL = '\n';     
    //文件结束标识
    public static final char EOF = (char) 0;  
    //源程序reader
    private final BufferedReader reader;
    private String line;                
    private int lineNum;                    
    private int currentPos;                   // 当前行相对位置，不是整个文件的offset！！

    private MessageHandler messageHandler;    // 消息处理的代理类

    public Source(BufferedReader reader)
        throws IOException
    {
        this.lineNum = 0;
        this.currentPos = -2;  // 设置为-2表示文件一行都没有读，后面的判断可以根据是否等于-2读文件第一行。
        this.reader = reader;
        this.messageHandler = new MessageHandler();
    }
    /**
     * @return 当前source的行位置
     */
    public int getLineNum()
    {
        return lineNum;
    }
    /**
     * @return 当前source的行位置的列位置
     */
    public int getPosition()
    {
        return currentPos;
    }

    /**
     * @return 要去读的字符
     * @throws Exception(read过程中的异常)
     */
    public char currentChar()
        throws Exception
    {
        // 第一次读?
        if (currentPos == -2) {
            readLine();
            return nextChar();
        }

        // 文件结束?
        else if (line == null) {
            return EOF;
        }

        // 行结束?
        else if ((currentPos == -1) || (currentPos == line.length())) {
            return EOL;
        }

        // 超过一行，换一行再读
        else if (currentPos > line.length()) {
            readLine();
            return nextChar();
        }

        // 正常读取当前行的某一列的字符
        else {
            return line.charAt(currentPos);
        }
    }

    /**
     *位置游标前进一步并返回对应的字符，记住source的位置游标<b>从来不后退，只有向前操作。</b>
     * @return 下一个要读取的字符
     * @throws Exception
     */
    public char nextChar()
        throws Exception
    {
        ++currentPos;
        return currentChar();
    }

    /**
     * 返回当前位置的字符但位置游标不增加，跟Stack（栈）的Peek方法一样效果。
     * @return 当前位置的字符
     * @throws Exception 
     */
    public char peekChar()
        throws Exception
    {
        currentChar();
        if (line == null) {
            return EOF;
        }

        int nextPos = currentPos + 1;
        return nextPos < line.length() ? line.charAt(nextPos) : EOL;
    }

    /**
     * 读入一行
     * @throws IOException
     */
    private void readLine()
        throws IOException
    {
        line = reader.readLine(); 
        currentPos = -1;
        //如果读成功，行数+1
        if (line != null) {
            ++lineNum;
        }

        //每成功读入一行，将当前行数和当前行文本内容以消息方式广播，方便监听器处理。
        if (line != null) {
            sendMessage(new Message(SOURCE_LINE,
                                    new Object[] {lineNum, line}));
        }
    }

   
    public void close()
        throws Exception
    {
        if (reader != null) {
            try {
                reader.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
    }

    
    public void addMessageListener(MessageListener listener)
    {
        messageHandler.addListener(listener);
    }

    
    public void removeMessageListener(MessageListener listener)
    {
        messageHandler.removeListener(listener);
    }

    /**
     * 通过代理类广播消息
     * @param message
     */
    public void sendMessage(Message message)
    {
        messageHandler.sendMessage(message);
    }
}
