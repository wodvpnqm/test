package com.qm.algorithms.algorithm453;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wodvpn on 2017/4/22.
 */
public class Solution {
    /**
     * n==1,0
     * n==2,
     *   不相等:1,2 1
     *   相等:1,1 0
     * n==3,
     *  1,2,3 -> 4,4,4
     *  (2,1)
     *  1+1*2=3
     *
     *  3,2,1
     *  f(1,2,2)=(3,3,3)
     *  2,1,1
     *  f(1,2,1)=1
     *  f(1,1,4)=f(4,4,4)
     *  3,3,0
     *  f(1,3,5)->f(2,4,5)->f(3,5,5)->f(4,6,5)->f(5,6,6)->f(6,7,6)-f(7,7,7)
     *  4,2
     *  f(1,2,2)->f(2,3,2)-f(3,3,3)
     *  2,1,1
     *  f(1,2,2,2)->f(2,3,3,2)->f(3,4,3,3)->f(4,4,4,4)
     *  2,1,1,1
     *
     *  1,2,3
     *  2,1,0
     *  3,2,1
     *  f(2,3,5)->f(3,4,5)->f(4,5,5)->f(5,6,5)->f(6,6,6)
     *  3,2,0
     *  f(1,2,3,4)=f(2,3,4,4)=f(3,4,4,4)=f(4,5,5,4)=f(5,5,6,5)=f(6,6,6,6)
     *  4,3,2,1
     *  5,6,8,8,5
     *  5,5,6,8,8
     *  4,4,3,1,1
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int steps = 0;
        for(int i =0;i<length;i++){
            steps += nums[i] - min;
        }
        return steps;
    }

    @Test
    public void test()
    {
        int [] array = new int[]{1,1,2147483647};
        Assert.assertTrue(minMoves(array) == 2147483646);
    }

    @Test
    public void test1()
    {
        int [] array = new int[]{5,6,8,8,5};
        Assert.assertTrue(minMoves(array) == 7);
    }

    @Test
    public void test2()
    {
        int [] array = new int[]{83,86,77,15,93,35,86,92,49,21};
        Assert.assertTrue(minMoves(array) == 487);
    }



}
