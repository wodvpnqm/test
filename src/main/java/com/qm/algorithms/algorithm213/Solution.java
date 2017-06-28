package com.qm.algorithms.algorithm213;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int maxRobFirst = 0;
        int maxNotRobFirst = 0;
        int prevNo = 0;
        int prevYes = 0;
        for (int i=1;i<nums.length-1;i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = nums[i] + temp;
        }
        maxRobFirst = 1 +  Math.max(prevNo, prevYes);

        prevNo = 0;
        prevYes = 0;
        for (int i=1;i<nums.length;i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = nums[i] + temp;
        }
        maxNotRobFirst = Math.max(prevNo, prevYes);

        return Math.max(maxNotRobFirst, maxRobFirst);
    }

    public void test()
    {

    }
}
