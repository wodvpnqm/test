package com.qm.algorithms.algorithms416;

import java.util.Arrays;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class Solution {

        public boolean canPartition(int[] nums) {
            if(nums.length == 1)
            {
                return false;
            }
            if(nums.length == 1)
            {
                return nums[0] == nums[1];
            }
            Arrays.sort(nums);
            int sum  = 0;
            for(int i=0;i<nums.length-3;i++)
                sum += nums[i];
            int lastThirdNum = nums[nums.length-3] - sum;
            int lastSecondNum = nums[nums.length-2] - sum;
            int lastNum = nums[nums.length-1] - sum;
            return lastThirdNum+lastSecondNum == lastNum;
        }
}
