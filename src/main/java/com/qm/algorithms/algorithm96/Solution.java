package com.qm.algorithms.algorithm96;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/26.
 */
public class Solution {
    public int numTrees(int n) {
        if(n <= 1)
            return 1;
        int [] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        //求dp 2..n
        for(int i=2;i<=n;i++)
        {
            //dp[2]= dp[0]*dp[1]+dp[1]*dp[0]
            for(int j=0;j<=i-1;j++)
            {
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }

    @Test
    public void test()
    {
        System.out.println(numTrees(2));
    }
}
