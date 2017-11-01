package com.qm.compiler.wci.frontend.pascal;


import com.qm.compiler.wci.frontend.EofToken;
import com.qm.compiler.wci.frontend.Scanner;
import com.qm.compiler.wci.frontend.Source;
import com.qm.compiler.wci.frontend.Token;

import static com.qm.compiler.wci.frontend.Source.EOF;

/**
 * <h1>PascalScanner</h1>
 *
 * <p>用于Pascal源程序的Scanner</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class PascalScanner extends Scanner
{
   
    public PascalScanner(Source source)
    {
        super(source);
    }

    /**
     * 提取source下一个Pascal Token。
     * @return token
     * @throws Exception.
     */
    protected Token extractToken()
        throws Exception
    {
        Token token;
        char currentChar = currentChar();

        //文件结束，返回一个特殊EofToken
        if (currentChar == EOF) {
            token = new EofToken(source);
        }
        else {
        	//将具体构成Token的细节放在Token中是否合适？也就是说Token本身包含逻辑是否合理？有待商榷
            token = new Token(source);
        }

        return token;
    }
}
