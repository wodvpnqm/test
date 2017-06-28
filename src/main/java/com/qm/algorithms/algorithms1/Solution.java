package com.qm.algorithms.algorithms1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int num = target-nums[i];
            if(map.containsKey(num))
            {
                int targetIndex = map.get(num);
                int min = Math.min(targetIndex,i);
                int max = Math.max(targetIndex,i);
                return new int[]{min,max};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
