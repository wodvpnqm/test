package com.qm.algorithms.algorithm523;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class Solution {

    public boolean checkSubarraySum1(int[] nums, int k) {
        int sum = 0;
        int startIndex = 0;
        int endIndex = nums.length-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 0)
            {
                if(i+1<nums.length && nums[i+1] == 0)
                {
                    return true;
                }
            }
            sum+=nums[i];
        }
        boolean leftTurn = true;
        while (startIndex < endIndex) {
            if(k == 0)
                return false;
            if(sum % k == 0)
            {
                return true;
            }
            if(leftTurn)
            {
                sum = sum - nums[startIndex];
                startIndex++;
            }else{
                sum = sum - nums[endIndex];
                endIndex--;
            }
            leftTurn = !leftTurn;

        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        boolean [] dp = new boolean[nums.length];
        for(int i=0;i<nums.length;i++)
        {

        }
        return false;
    }


    public boolean checkSubarraySu1(int[] nums, int k) {

        String s = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7},-6));
    }
}