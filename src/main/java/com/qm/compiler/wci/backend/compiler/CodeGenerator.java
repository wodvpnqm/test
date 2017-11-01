package com.qm.compiler.wci.backend.compiler;

import com.qm.compiler.wci.backend.Backend;
import com.qm.compiler.wci.intermediate.ICode;
import com.qm.compiler.wci.intermediate.SymTab;
import com.qm.compiler.wci.message.Message;

import static com.qm.compiler.wci.message.MessageType.COMPILER_SUMMARY;

/**
 * <h1>CodeGenerator</h1>
 *
 * <p>编译器的后端代码生成器</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class CodeGenerator extends Backend
{
    public void process(ICode iCode, SymTab symTab)
        throws Exception
    {
        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        int instructionCount = 0;

        // 发送编译摘要消息
        sendMessage(new Message(COMPILER_SUMMARY,
                                new Number[] {instructionCount,
                                              elapsedTime}));
    }
}
