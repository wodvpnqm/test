package com.qm.jvm.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnsafeSequence {

    private int value;

    public int getNext(){
        return value++;
    }

    public static void main(String[] args) throws Exception{
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
        UnsafeSequence us = new UnsafeSequence();
        for(int i=0;i<1000;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int current = us.getNext();
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
