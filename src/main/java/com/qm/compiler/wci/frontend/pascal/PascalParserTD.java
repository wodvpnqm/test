package com.qm.compiler.wci.frontend.pascal;


import com.qm.compiler.wci.frontend.EofToken;
import com.qm.compiler.wci.frontend.Parser;
import com.qm.compiler.wci.frontend.Scanner;
import com.qm.compiler.wci.frontend.Token;
import com.qm.compiler.wci.message.Message;

import static com.qm.compiler.wci.message.MessageType.PARSER_SUMMARY;

/**
 * <h1>PascalParserTD</h1>
 * <p>
 * <p>Top-Down模式的Pascal Parser</p>
 * <p>
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class PascalParserTD extends Parser {

    public PascalParserTD(Scanner scanner) {
        super(scanner);
    }

    /**
     * Pascal的解析过程，产生Pascal相关的iCode和symbol table
     */
    public void parse()
            throws Exception {
        Token token;
        long startTime = System.currentTimeMillis();

        while (!((token = nextToken()) instanceof EofToken)) {
        }

        // 发送编译摘要信息
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        sendMessage(new Message(PARSER_SUMMARY,
                new Number[]{token.getLineNumber(),
                        getErrorCount(),
                        elapsedTime}));
    }

    public int getErrorCount() {
        return 0;
    }
}
