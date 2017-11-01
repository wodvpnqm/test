package com.qm.compiler.wci.frontend;

/**
 * <h1>Scanner(Token扫描器)</h1>
 *
 * <p>语言无关的scanner，产生Token</p>
 * 
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 * 
 * @see wci.frontend.pascal.PascalScanner Pascal子类
 */
public abstract class Scanner
{
    protected Source source;     
    private Token currentToken;  //当前Token

    public Scanner(Source source)
    {
        this.source = source;
    }

    public Token currentToken()
    {
        return currentToken;
    }

    /**
     * 以source中的char序列模式抽取token
     * @return 下一个token
     * @throws Exception
     */
    public Token nextToken()
        throws Exception
    {
        currentToken = extractToken();
        return currentToken;
    }

    /**
     * 因为每个源语言的Token构成方式不一样，所以这个具体语言的子类去实现。
     * @return 语言相关的Token
     * @throws Exception
     */
    protected abstract Token extractToken()
        throws Exception;

   /**
    * source的一个快捷方法，可让子类比不依赖source
    * @return 要读取的字符
    * @throws Exception
    */
    public char currentChar()
        throws Exception
    {
        return source.currentChar();
    }
    /**
     * source的一个快捷方法，可让子类比不依赖source
     * @return 下一个要读取的字符
     * @throws Exception
     */
   
    public char nextChar()
        throws Exception
    {
        return source.nextChar();
    }
}
