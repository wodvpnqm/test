package com.qm.algorithms.algorithm413;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/5/17.
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)
            return 0;
        int [] dp = new int[A.length-1];
        for(int i=1;i<A.length;i++){
            dp[i-1] = A[i] - A[i-1];
        }
        int sum = 0;
        int currentLength = 1;
        for(int i=0;i<dp.length;){
            while(i+1 < dp.length && dp[i] == dp[i+1]){
                i++;
                currentLength++;
            }
            if(currentLength > 1){
                sum += ((currentLength*(currentLength-1))>>1);
            }
            if(currentLength == 1){
                i++;
            }
            currentLength = 1;
        }
        return sum;
    }


    @Test
    public void test(){
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,5,6}));
    }
}