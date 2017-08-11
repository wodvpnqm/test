package com.qm.compiler.wci.message;

/**
 * <h1>MessageListener</h1>
 *
 * <p>消息监听器公共接口</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public interface MessageListener
{
    /**
     * @param message 要处理的消息
     */
    public void messageReceived(Message message);
}
