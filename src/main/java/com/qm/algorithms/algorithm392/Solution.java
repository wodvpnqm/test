package com.qm.algorithms.algorithm392;

/**
 * Created by wodvpn on 2017/4/27.
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen > tLen) return false;
        int [] dp = new int[sLen+1];
        dp[0] = 0;
        for(int i=0;i<sLen;i++){
            int index = t.indexOf(s.charAt(i),dp[i]);
            if(index < 0) return false;
            dp[i+1] = index + 1;
        }
        return true;
    }
}
