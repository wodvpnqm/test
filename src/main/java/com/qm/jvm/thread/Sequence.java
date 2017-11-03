package com.qm.jvm.thread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ThreadSafe
public class Sequence {

    @GuardedBy("this")
    private int value;

    public synchronized int getNext() {
        return value++;
    }

    public static void main(String[] args) throws Exception{
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
        Sequence s = new Sequence();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int current = s.getNext();
                    set.add(current);
                    System.out.println(current);
                }
            });
            thread.start();
        }
        Thread.sleep(3000);
        System.out.println("总数:"+set.size());
    }
}
