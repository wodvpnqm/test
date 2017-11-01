package com.qm.compiler.wci.message;

/**
 * <h1>Message</h1>
 *
 * <p>消息类</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class Message
{
	//消息类型
    private final MessageType type;
    //消息报文
    private final Object body;
    public Message(MessageType type, Object body)
    {
        this.type = type;
        this.body = body;
    }

    
    public MessageType getType()
    {
        return type;
    }

    
    public Object getBody()
    {
        return body;
    }
}
