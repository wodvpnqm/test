package com.qm.algorithms.algorithm53;

import org.junit.Test;

import java.util.TreeSet;

/**
 * Created by wodvpn on 2017/4/24.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < length; ++i) {
            sum = 0;
            for (int j = i; j < length; ++j) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }


    /**
     * nums[length-1]与最大连续子数组的关系:
     * 1.nums[length-1]单独构成最大连续子数组
     * 2.最大连续子数组以nums[length-1]结尾
     * 3.最大子数组跟nums[length-1]没关系,最大子数组在nums[0]到nums[length-2]之间
     * <p>
     * 所求的结果为1,2,3中的最大值(1,2,3互斥,但是我们都要求)
     * 假设:
     * 以nums[length-1]结尾的最大子数组为End[n-1]
     * 在[0,length-1]范围内的最大子数组和为All[n-1]
     * <p>
     * All[i] = max{ nums[i]，End[i-1]+nums[i]，All[i-1] }
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int length = nums.length;
        int[] End = new int[length];
        int[] All = new int[length];
        End[0] = All[0] = nums[0];
        for (int i = 1; i < length; ++i) {
            End[i] = Math.max(End[i - 1] + nums[i], nums[i]);
            All[i] = Math.max(End[i], All[i - 1]);
        }
        return All[length - 1];
    }

    /**
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; ++i) {
            sum = Math.max(sum,0);
            sum += nums[i];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }

    private int maxSumSubArray(int[] a, int k) {
        int max = Integer.MIN_VALUE;
        int sumj = 0;
        TreeSet<Integer> s = new TreeSet();
        s.add(0);
        for (int i = 0; i < a.length; i++) {
            int t = sumj + a[i];
            sumj = t;
            //找到s中最大的数是使得:min[x>=sumj-k|x属于s]
            Integer gap = s.ceiling(sumj - k);
            if (gap != null) max = Math.max(max, sumj - gap);
            s.add(t);
        }

        return max;
    }

    public int maxSubArray3(int[] A) {
        int length = A.length;
        int[] result = mergeMaxSubArray(A, 0, length - 1);
        return result[0];
    }

    public int[] mergeMaxSubArray(int[] array, int start, int end) {
        if (start == end) {
            return new int[]{array[start], start, end};
        }
        int mid = start + (end - start) / 2;
        int[] leftResult = mergeMaxSubArray(array, start, mid);
        int[] rightResult = mergeMaxSubArray(array, mid + 1, end);
        if (leftResult[0] > 0) {
            if (rightResult[0] > 0) {
                if (leftResult[2] + 1 == rightResult[1]) {
                    return new int[]{leftResult[0] + rightResult[0], leftResult[1], rightResult[2]};
                }
                if (rightResult[0] > leftResult[0]) {
                    return rightResult;
                } else {
                    return leftResult;
                }
            } else {
                return leftResult;
            }
        } else {
            if (rightResult[0] > 0) {
                return rightResult;
            } else {
                if (rightResult[0] > leftResult[0]) {
                    return rightResult;
                } else {
                    return leftResult;
                }
            }
        }
    }

    @Test
    public void test() {
        System.out.println(maxSubArray3(new int[]{1, 2, 3}));
    }

    @Test
    public void test1() {
        System.out.println(maxSubArray3(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void test2() {
        System.out.println(maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    //[-2,1,-3,4,-1,2,1,-5,4]


}
