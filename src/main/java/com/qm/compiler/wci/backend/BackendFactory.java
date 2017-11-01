package com.qm.compiler.wci.backend;


import com.qm.compiler.wci.backend.compiler.CodeGenerator;
import com.qm.compiler.wci.backend.interpreter.Executor;

/**
 * <h1>BackendFactory</h1>
 *
 * <p>产生编译器或解释器后端的工厂</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class BackendFactory
{
    /**
     * 视参数产生编译器或解释器后端
     * @param operation "compile"或者"execute"
     * @return 后端组件
     * @throws Exception if an error occurred.
     */
    public static Backend createBackend(String operation)
        throws Exception
    {
        if (operation.equalsIgnoreCase("compile")) {
            return new CodeGenerator();
        }
        else if (operation.equalsIgnoreCase("execute")) {
            return new Executor();
        }
        else {
            throw new Exception("后端工厂: 不支持的操作 '" +
                                operation + "'");
        }
    }
}
