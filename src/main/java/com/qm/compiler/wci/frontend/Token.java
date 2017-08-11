package com.qm.compiler.wci.frontend;

/**
 * <h1>Token</h1>
 *
 * <p>Scanner扫描返回的最小语法单元，也是个比不可少的框架类</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class Token
{
    protected TokenType type;  // 语言相关的Token类型
    protected String text;     // 字面文本
    protected Object value;    // 值，如果是一些常量，直接可以算出值来的
    protected final Source source;   // source
    protected int lineNum;     // 所在行
    protected int position;    // Token第一个字符所在的位置，即行中列位置

    
    public Token(Source source)
        throws Exception
    {
        this.source = source;
        this.lineNum = source.getLineNum();
        this.position = source.getPosition();

        extract();
    }
    public TokenType getType()
    {
        return type;
    }
    public String getText()
    {
        return text;
    }
    public Object getValue()
    {
        return value;
    }
    public int getLineNumber()
    {
        return lineNum;
    }
    public int getPosition()
    {
        return position;
    }

    /**
     * 当前为演示框架组件，每次都返回一个字符的Token，实际不是这样的，后面章节会改。<br>
     * 但是吞噬原理是一样的，每当Token构成完之后，都把位置游标前移一步。
     * @throws Exception
     */
    protected void extract()
        throws Exception
    {
        text = Character.toString(currentChar());
        value = null;
        //吞噬&前进
        nextChar();
    }

    protected char currentChar()
        throws Exception
    {
        return source.currentChar();
    }

    protected char nextChar()
        throws Exception
    {
        return source.nextChar();
    }
    
    protected char peekChar()
        throws Exception
    {
        return source.peekChar();
    }
}
