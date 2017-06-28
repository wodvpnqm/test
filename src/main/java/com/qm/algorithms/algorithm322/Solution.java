package com.qm.algorithms.algorithm322;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wodvpn on 2017/5/17.
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        int current = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    @Test
    public void test() {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    @Test
    public void test1() {
        System.out.println(coinChange(new int[]{2}, 3));
    }

}
