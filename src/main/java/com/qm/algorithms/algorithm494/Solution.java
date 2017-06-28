package com.qm.algorithms.algorithm494;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        //迭代求所有的情况
        int sum = 0;
        int [] state = new int[nums.length];
        while(state[0] < 2)
        {
            for(int i=0;i<nums.length;i++)
            {

            }
        }
        return 0;


    }

    public int inner(int [] nums,int S,int start,int end)
    {
        System.out.println("nums="+ Arrays.toString(nums)+",S="+S+"start="+start+",end="+end);
        if(start == end)
        {
            if(nums[start] == S)
            {
                return 1;
            }
            return 0;
        }
        return inner(nums,S-nums[end],start,end-1)
                + inner(nums,S+nums[end],start,end-1);
    }

    @Test
    public void test()
    {
        System.out.println(findTargetSumWays(new int[]{1,1,1},1));
    }
}
