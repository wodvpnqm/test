package com.qm.algorithms.algorithm516;

/**
 * Created by wodvpn on 2017/4/27.
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        return inner(s,0,s.length()-1);
    }

    public int inner(String str, int s, int e){
        if(s == e) return 1;
        if(s > e) return 0;
        int result = 0;
        if(str.charAt(s) == str.charAt(e)){
            result = 2 + inner(str,s+1,e-1);
        }else{
            result = Math.max(inner(str,s,e-1), inner(str,s+1,e));
        }
        return result;
    }
}