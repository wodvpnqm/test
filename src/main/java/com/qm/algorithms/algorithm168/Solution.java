package com.qm.algorithms.algorithm168;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/22.
 */
public class Solution {
    /**
     * 1->0->A
     * 2->1->B
     * ...
     * 26->25->Z
     * 27->26->AA
     * 28->27->AB
     * 28->AB
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        String result = "";
        while(n>0){
            result = (char)((n-1)%26 +'A') + result;
            n = (n-1)/26;
        }
        return result;
    }

    /**
     * 1->A->65
     * B->66
     * C->67
     * @param num
     * @return
     */
    public char intToChar(int num)
    {
        return (char)(num+65);
    }

    @Test
    public void test()
    {
        Assert.assertTrue(intToChar(0)== 'A');
    }

    @Test
    public void test1()
    {
        String result = convertToTitle(1);
        Assert.assertTrue(result.equals("A"));
    }

    @Test
    public void test2()
    {
        String result = convertToTitle(26);
        Assert.assertTrue(result.equals("Z"));
    }

    @Test
    public void test3()
    {
        String result = convertToTitle(27);
        Assert.assertTrue(result.equals("AA"));
    }
}
