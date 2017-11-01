package com.qm.compiler.wci.frontend;

/**
 * <h1>EofToken</h1>
 *
 * <p>表示文件结束的特殊Token</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class EofToken extends Token
{
   
    public EofToken(Source source)
        throws Exception
    {
        super(source);
    }

    
    protected void extract(Source source)
        throws Exception
    {
    }
}
