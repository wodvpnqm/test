package com.qm.jdk8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProjectLines {

    public static void main(String[] args) throws Exception{
        long count = Files.walk(Paths.get("H:\\code\\courses-microservice"))                      // 获得项目目录下的所有目录及文件
                .filter(file -> !Files.isDirectory(file))          // 筛选出文件
                .filter(file -> file.toString().endsWith(".java")) // 筛选出 java 文件
                .flatMap(file -> {
                    try {
                        return Files.lines(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })                // 按行获得文件中的文本
                .filter(line -> !line.trim().isEmpty())            // 过滤掉空行
                .count();
        System.out.println("代码行数：" + count);
    }
}
