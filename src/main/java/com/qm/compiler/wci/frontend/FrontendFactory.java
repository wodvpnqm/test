package com.qm.compiler.wci.frontend;


import com.qm.compiler.wci.frontend.pascal.PascalParserTD;
import com.qm.compiler.wci.frontend.pascal.PascalScanner;

/**
 * <h1>前端工厂类</h1>
 * <p>
 * <p>根据具体源语言创建对应的Parser，本书中只有Pascal。</p>
 * <p>
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class FrontendFactory {
    /**
     * 创建Parser
     *
     * @param language 源语言名称，目前只支持Pascal
     * @param type     解析器类型，目前只支持top-down类型
     * @param source   代表源文件的source对象
     * @return 解析器
     * @throws Exception
     */
    public static Parser createParser(String language, String type,
                                      Source source)
            throws Exception {
        if (language.equalsIgnoreCase("Pascal") &&
                type.equalsIgnoreCase("top-down")) {
            Scanner scanner = new PascalScanner(source);
            return new PascalParserTD(scanner);
        } else if (!language.equalsIgnoreCase("Pascal")) {
            throw new Exception("Parser 工厂: 不支持的语言 '" +
                    language + "'");
        } else {
            throw new Exception("Parser 工厂: 不支持的类型 '" +
                    type + "'");
        }
    }
}
