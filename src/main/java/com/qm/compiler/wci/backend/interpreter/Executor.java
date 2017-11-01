package com.qm.compiler.wci.backend.interpreter;

import com.qm.compiler.wci.backend.Backend;
import com.qm.compiler.wci.intermediate.ICode;
import com.qm.compiler.wci.intermediate.SymTab;
import com.qm.compiler.wci.message.Message;

import static com.qm.compiler.wci.message.MessageType.INTERPRETER_SUMMARY;


/**
 * <h1>Executor</h1>
 *
 * <p>解释器后端执行器</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class Executor extends Backend
{
    public void process(ICode iCode, SymTab symTab)
        throws Exception
    {
        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        int executionCount = 0;
        int runtimeErrors = 0;

        // 发送解释摘要消息
        sendMessage(new Message(INTERPRETER_SUMMARY,
                                new Number[] {executionCount,
                                              runtimeErrors,
                                              elapsedTime}));
    }
}
