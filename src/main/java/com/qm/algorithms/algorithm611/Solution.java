package com.qm.algorithms.algorithm611;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wodvpn on 2017/6/24.
 */
public class Solution {
    /**
     * 611. Valid Triangle Number
     * 合法的三角数
     *
     * 给定一个非负整数,你的任务是找出所有的三元组,使得三个数可以形成
     * 一个三角形.
     *
     * 1.三角形的三条边的关系?
     * x1+x2>x3
     *
     *
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int total = 0;
        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int twoSum = nums[i] + nums[j];
                for(int k=j+1;k<nums.length;k++){
                    if(twoSum > nums[k]){
                        System.out.println("i="+i+",j="+j+",k="+k);
                        total++;
                    }else{
                        break;
                    }
                }
            }
        }
        return total;
    }

    @Test
    public void test(){
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
    }
}
