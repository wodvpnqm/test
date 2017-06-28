package com.qm.algorithms.algorithm368;

import org.junit.Test;

import java.util.*;

/**
 * Created by wodvpn on 2017/4/26.
 */
public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> accumulation = new ArrayList<>();
        accumulation.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++)
        {
            int accuLength = accumulation.size();
            for(int j=0;j<accuLength;j++)
            {
                List<Integer> newItem = new ArrayList<>(accumulation.get(j));
                if(newItem.isEmpty()||(nums[i]%(newItem.get(newItem.size()-1)))==0)
                {
                    newItem.add(nums[i]);
                    accumulation.add(newItem);
                    if(newItem.size() > result.size())
                    {
                        result = newItem;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test()
    {
        System.out.println(largestDivisibleSubset(new int[]{3,2,4,8}));
    }

    @Test
    public void test1()
    {
        System.out.println(largestDivisibleSubset(new int[]{4,8,10,240}));
    }

    @Test
    public void test2()
    {
        System.out.println(largestDivisibleSubset(new int[]{3,9,2,4,8}));
    }

    //[4,8,10,240]
}
