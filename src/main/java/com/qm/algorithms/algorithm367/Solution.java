package com.qm.algorithms.algorithm367;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/22.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        if((int)sqrt == sqrt)
        {
            return true;
        }
        return false;
    }

    @Test
    public void test()
    {
        System.out.println(isPerfectSquare(4));
    }
}