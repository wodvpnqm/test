package com.qm.jdk8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LambdaException {

    public void foo() {
        Stream.of("a", "b").forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                try {
                    new FileInputStream(s).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void foo1() {
        Stream.of("a", "b").forEach(s -> {
            try {
                new FileInputStream(s).close();
            } catch (IOException e) {
                throw new RuntimeException("file not found");
            }
        });
    }

    @FunctionalInterface
    interface MyConsumer {
        void accept(String s) throws Exception;
    }

    public void foo(String f, MyConsumer consumer) throws Exception {
        consumer.accept(f);
    }

    public void client() throws Exception {
        foo("a", s -> new FileInputStream(s).close());
    }
}
