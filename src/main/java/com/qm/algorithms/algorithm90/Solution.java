package com.qm.algorithms.algorithm90;

import org.junit.Test;

import java.util.*;

/**
 * Created by wodvpn on 2017/4/26.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0;i<nums.length;)
        {
            int count = 1;
            while(i+count<nums.length && nums[i+count-1] == nums[i+count])
            {
                count++;
            }
            int previousN = result.size();
            for(int k=0; k<previousN; k++){
                List<Integer> instance = new ArrayList<>(result.get(k));
                for(int j=0; j<count; j++){
                    instance.add(nums[i]);
                    result.add(new ArrayList<>(instance));
                }
            }
            i += count;
        }
        return result;
    }


    @Test
    public void test()
    {
        System.out.println(subsetsWithDup(new int[]{1,2,3}));
    }

    @Test
    public void test1()
    {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }

    @Test
    public void test2()
    {
        System.out.println(subsetsWithDup(new int[]{1,1,2,2}));
    }
//[      ]
//[    [1],  [1, 2, 2],  [1, 2] ]
    //[1,1,2,2]


}
