package com.qm.algorithms.algorithm198;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class Solution {
    public int rob(int[] nums) {
       int rob = 0;
       int notrob = 0;
       int temp = 0;
       for(int i=0;i<nums.length;i++)
       {
           temp = notrob;
           notrob = Math.max(rob,notrob);
           rob = temp+nums[i];
       }
       return Math.max(notrob,rob);
    }

    public int rob1(int[] nums) {
        int a = 0;
        int b = 0;
        int temp = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(i%2 == 0)
            {
                a = Math.max(a+nums[i],b);
            }else{
                b = Math.max(a,b+nums[i]);
            }
        }
        return Math.max(a,b);
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{1,1}));
    }
}
