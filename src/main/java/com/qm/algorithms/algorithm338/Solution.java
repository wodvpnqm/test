package com.qm.algorithms.algorithm338;

/**
 * Created by wodvpn on 2017/5/17.
 */
public class Solution {
    public int[] countBits(int num) {
        int [] dp = new int[num+1];
        for(int i=1;i<dp.length;i++){
            if((i&1) == 1){
                dp[i] = 1 + dp[i-1];
            }else{
                dp[i] = dp[i>>1];
            }
        }
        return dp;
    }
}
