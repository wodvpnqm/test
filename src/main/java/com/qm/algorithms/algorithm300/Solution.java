package com.qm.algorithms.algorithm300;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wodvpn on 2017/4/27.
 */
public class Solution {


    public int lengthOfLIS1(int[] nums) {

        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        int [][] dp = new int[nums.length+1][nums.length+1];
        List<Integer> current = new ArrayList<>();
        int max = 0;
        for(int j=0;j<nums.length;j++)
        {
            current.add(nums[j]);
            for(int i=j+1;i<nums.length;i++)
            {
                int top = current.get(current.size() - 1);
                if(nums[i] > top)
                    current.add(nums[i]);
            }
            max = Math.max(current.size(),max);
            current.clear();
        }

        return max;
    }


    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        List<Integer> current = new ArrayList<>();
        int max = 0;
        for(int j=0;j<nums.length;j++)
        {
            current.add(nums[j]);
            for(int i=j+1;i<nums.length;i++)
            {
                int top = current.get(current.size()-1);
                if(nums[i] < top){
                    if(current.size() == 1||current.get(current.size()-2) < nums[i])
                    {
                        current.remove(current.size()-1);
                        current.add(nums[i]);
                    }
                }else if(nums[i] > top)
                {
                    current.add(nums[i]);
                }
            }
            max = Math.max(current.size(),max);
            current.clear();
        }

        return max;
    }

    @Test
    public void test()
    {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
    @Test
    public void test1()
    {
        System.out.println(lengthOfLIS1(new int[]{10,9,2,5,3,4}));
    }
}
