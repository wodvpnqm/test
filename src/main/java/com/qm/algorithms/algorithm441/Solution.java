package com.qm.algorithms.algorithm441;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/22.
 */
public class Solution {
    public int arrangeCoins(int n) {
        double d = (-3+Math.sqrt(1+8*n))/2.0;
        return (int)Math.floor(d);
    }

    @Test
    public void test()
    {
        //1804232485
        //1804289383
        System.out.println(arrangeCoins(1804289383
        ));
        System.out.println((-1+Math.sqrt(1+8*1804289383))/2.0);
        System.out.println(60070L*(60070+1)/2);
    }
}