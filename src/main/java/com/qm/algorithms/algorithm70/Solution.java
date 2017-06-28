package com.qm.algorithms.algorithm70;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class Solution {
    public int climbStairs(int n) {
        int preOfPrev = 0;
        int prev = 1;
        int current = 0;
        for(int i=0;i<n;i++)
        {
            current = preOfPrev + prev;
            preOfPrev = prev;
            prev = current;
        }
        return current;
    }
}