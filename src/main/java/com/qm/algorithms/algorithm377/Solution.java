package com.qm.algorithms.algorithm377;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/27.
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        return dfs(nums,0,target);
    }

    public int dfs(int [] nums,int level,int target){
        System.out.println(target);
        if(target == 0)
            return 1;
        if(target < 0)
            return 0;
        if(level == nums.length){
            if(target == 0)
                return 1;
            return 0;
        }
        int current = nums[level];
        int maxNum = target/current;
        int result = 0;
        for(int i=0;i<=maxNum;i++){
            result += dfs(nums,level+1,target-current*i);
        }
        return result;
    }

    @Test
    public void test()
    {
        System.out.println(combinationSum4(new int[]{1,2,3},4));
    }
}
