package com.qm.algorithms.algorithm400;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/22.
 */
public class Solution {

    /**
     * 1.循环减法
     * 2.寻找数字
     * 3.寻找位数
     *
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        long input = n;
        long bits = 1;
        long lastInput = n;
        //求区间
        while(input > 0)
        {
            lastInput = input;
            input = input - numOfNumbers(bits);
            bits++;
        }
        bits--;
        //寻找数字
        long order = lastInput/bits;
        long reminder = lastInput%bits;

        //存在位数
        long firstNumber = (long)Math.pow(10,bits-1);
        long targetNumber = firstNumber + (order+(reminder==0?0:1)) - 1;
        long nthDigit = (reminder==0?(bits - 1):(reminder-1));
        String str = targetNumber+"";
        return (int)(str.charAt((int)nthDigit)-'0');
    }

    /**
     * 1->9
     *2->180
     * 求给定位数的数一共有多少个数字
     * @param numOfBits
     * @return
     */
    public long numOfNumbers(long numOfBits)
    {
        return (long)(numOfBits*(Math.pow(10,numOfBits)-Math.pow(10,numOfBits-1)));
    }

    @Test
    public void test()
    {
        System.out.println(findNthDigit(193));
    }
}
