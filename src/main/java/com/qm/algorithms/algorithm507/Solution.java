package com.qm.algorithms.algorithm507;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wodvpn on 2017/4/22.
 */
public class Solution {
    /**
     * 28
     * 1.质因数,组合,相加
     * 2.遍历,相加
     * 3.
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        int maxDivitor = num >> 1;
        int sum = 1;
        Set<Integer> set = new HashSet<Integer>();
        int result = 1;
        for(int i=2;i<=maxDivitor;i++)
        {
            if(!set.contains(i) && num % i == 0)
            {
                set.add(i);
                result = num / i;
                set.add(result);
                sum += i;
                sum += result;
            }
        }
        return sum == num;
    }

    @Test
    public void test()
    {
        Assert.assertTrue(checkPerfectNumber(28));;
    }
}