package com.qm.algorithms.algorithm416;

/**
 * Created by wodvpn on 2017/4/26.
 */
public class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if((sum & 1) == 1)
        {
            return false;
        }
        int target = sum/2;
        return subsetSum(nums,target)>0;
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

}
