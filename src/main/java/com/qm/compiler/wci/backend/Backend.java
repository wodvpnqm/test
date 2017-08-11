package com.qm.compiler.wci.backend;

import com.qm.compiler.wci.intermediate.ICode;
import com.qm.compiler.wci.intermediate.SymTab;
import com.qm.compiler.wci.message.Message;
import com.qm.compiler.wci.message.MessageHandler;
import com.qm.compiler.wci.message.MessageListener;
import com.qm.compiler.wci.message.MessageProducer;

/**
 * <h1>Backend</h1>
 * <p>
 * <p>框架后端组件类</p>
 * <p>
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public abstract class Backend implements MessageProducer {
    // 消息处理代理类
    protected static MessageHandler messageHandler = new MessageHandler();
    protected SymTab symTab;  // 符号表
    protected ICode  iCode;    // 中间码即语法树

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
     * 处理来自前端Parser产生的中间码和符号表，或编译生成代码或执行
     *
     * @param iCode  符号表
     * @param symTab 中间码即语法树
     * @throws Exception
     */
    public abstract void process(ICode iCode, SymTab symTab)
            throws Exception;

    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }

    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }
}
