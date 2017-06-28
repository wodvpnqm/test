package com.qm.algorithms.algorithm172;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/22.
 */
public class Solution {


    /**
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int zeroNum = 0;
        int currentNum = n;
        while(currentNum>=5)
        {
            currentNum = currentNum/5;
            zeroNum += currentNum;
        }
        return zeroNum;
    }


    /**
     * @param n
     * @return
     */
    public int trailingZeroes1(int n) {
        if(n == 0)
            return 0;
        double result =Math.log(n)/Math.log(5);
        if(result < 1)
            return 0;
        return (int)Math.ceil(result);
    }

    @Test
    public void test()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(factor(i+1));
        }
        System.out.println(factor(30));
    }
    @Test
    public void test1()
    {
        System.out.println(trailingZeroes1(2));
    }

    public long factor(long n)
    {
        long result = 1;
        for(long i=2;i<=n;i++)
        {
            result *=  i;
        }
        return result;
    }


}
