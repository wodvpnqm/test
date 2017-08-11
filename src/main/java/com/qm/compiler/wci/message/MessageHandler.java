package com.qm.compiler.wci.message;

import java.util.ArrayList;

/**
 * <h1>MessageHandler</h1>
 *
 * <p>一个句柄类用于替代MessageProducer处理消息</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class MessageHandler
{
    private Message message;    // 消息
    private ArrayList<MessageListener> listeners;  // 监听器列表
    public MessageHandler()
    {
        this.listeners = new ArrayList<MessageListener>();
    }
    public void addListener(MessageListener listener)
    {
        listeners.add(listener);
    }
    public void removeListener(MessageListener listener)
    {
        listeners.remove(listener);
    }
    public void sendMessage(Message message)
    {
        this.message = message;
        notifyListeners();
    }
    private void notifyListeners()
    {
        for (MessageListener listener : listeners) {
            listener.messageReceived(message);
        }
    }
}
