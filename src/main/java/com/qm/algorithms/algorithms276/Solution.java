package com.qm.algorithms.algorithms276;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class Solution {
    public int numWays(int n, int k) {
        if(n == 0||k == 0)
            return 0;
        int [] ways = new int[n];
        ways[0] = 0;
        for(int i=1;i<n;i++)
        {
            ways[i] = ways[i-1] + (k-1);
        }
        return ways[n-1];
    }
}
