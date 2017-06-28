package com.qm.algorithms.algorithms303;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class NumArray {

    private int [] nums;
    private int [] sums;

    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
        init();
    }

    public void init()
    {
        int currentSum = 0;
        for(int i=0;i<nums.length;i++)
        {
            currentSum += nums[i];
            sums[i] = currentSum;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j]-(i>0?sums[i-1]:0);
    }

    public static void main(String[] args) {
        int [] nums = new int[]{-2,0,3,-5,2,-1};
        NumArray na = new NumArray(nums);
        System.out.println(na.sumRange(0,2));
    }

}
