package com.qm.algorithms.algorithm357;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/5/17.
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<dp.length;i++){
            dp[i] = dp[i-1] + inner(i);
        }
        return dp[n];
    }

    private int inner(int x){
        int product = 9;
        for(int i=0;i<x-1;i++){
            product = product * (9 - i);
        }
        return product;
    }

    @Test
    public void test(){
        System.out.println(countNumbersWithUniqueDigits(2));
    }

}