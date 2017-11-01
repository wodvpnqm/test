package com.qm.compiler.wci.message;

/**
 * <h1>MessageProducer</h1>
 *
 * <p>能够产生消息的类的公共接口，source, scanner, parser, backend都能产生消息</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public interface MessageProducer
{
    /**
     * @param listener 要加入的监听器
     */
    public void addMessageListener(MessageListener listener);

    /**
     * @param listener 要移除的监听器
     */
    public void removeMessageListener(MessageListener listener);

    /**
     * @param message 要向所有注册的监听器广播的消息
     */
    public void sendMessage(Message message);
}
