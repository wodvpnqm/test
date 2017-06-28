package com.qm.algorithms.algorithm78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wodvpn on 2017/4/26.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,nums,0,new ArrayList<Integer>());
        return result;
    }

    public void dfs(List<List<Integer>> result,int[] input,int level,List<Integer> current)
    {
        //System.out.println(current);
        //System.out.println(result);
        if(level == input.length)
        {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        dfs(result,input,level+1,current);
        current.add(input[level]);
        dfs(result,input,level+1,current);
        current.remove(current.size()-1);
    }

    public List<List<Integer>> iterator(int [] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());
        for(int i=0;i<nums.length;i++)
        {
            //取出每一个值,放入
            int length = result.size();
            for(int j=0;j<length;j++)
            {
                List<Integer> current = result.get(j);
                List<Integer> newList = new ArrayList(current);
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }

    public List<List<Integer>> manipulation(int [] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int num_subset = (int)Math.pow(2, nums.length);
        for(int i=0;i<num_subset;i++)
        {
            result.add(new ArrayList());
        }
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < num_subset; j++)
                if (((j >> i) & 1) > 0)
                    result.get(j).add(nums[i]);
        return result;
    }

    public List<List<Integer>> manipulation1(int [] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int num_subset = (int)Math.pow(2, nums.length);
        for (int j = 0; j < num_subset; j++)
        {
            List<Integer> current = new ArrayList<>();
            for (int i = 1; i <=nums.length; i++)
            {
                if ((i & j) == i)
                    current.add(nums[i-1]);
            }
            result.add(current);
        }
        return result;
    }

    @Test
    public void test()
    {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    @Test
    public void test1()
    {
        System.out.println(iterator(new int[]{1,2,3}));
    }

    @Test
    public void test2()
    {
        System.out.println(manipulation1(new int[]{1,2,3}));
    }

}
