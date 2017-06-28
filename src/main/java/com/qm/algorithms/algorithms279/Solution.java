package com.qm.algorithms.algorithms279;

/**
 * Created by wodvpn on 2017/4/23.
 */
public class Solution {
    public int numSquares(int n) {
        if (n < 1) return n;
        int[] dp = new int[n + 1];
        //i->(1,n)
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            //j->(1,根号i)
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public int numSquares1(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        for (int a = 0; a * a <= n; ++a) {
            int b = (int)Math.sqrt(n - a * a);
            if (a * a + b * b == n) {
                return (a>0?1:0) + (b>0?1:0);
            }
        }
        return 3;
    }
}