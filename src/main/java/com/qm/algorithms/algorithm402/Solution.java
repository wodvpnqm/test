package com.qm.algorithms.algorithm402;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/28.
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        return inner(num,k);
    }

    public String inner(String nums,int k){
        if(k == 0||nums.length() == 0){
            return nums;
        }
        if(nums.charAt(0) == '0'){
            return inner(nums.substring(1,nums.length()),k);
        }
        if(nums.length() == 2)
        {
            return nums.charAt(0) >nums.charAt(1)?nums.substring(1,2):nums.substring(0,1);
        }

        for(int i=0;i<nums.length();i++){
            if(i > 0  ){
                if(nums.charAt(i-1)>nums.charAt(i)){
                    return nums.substring(i-1,nums.length());
                }
            }
        }
        return nums.substring(0,nums.length()-1);
    }

    @Test
    public void test()
    {
        System.out.println(removeKdigits("1432219",3));
    }
}
