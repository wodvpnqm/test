package com.qm.algorithms.algorithms15;

import org.junit.Test;

import java.util.*;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        //第一个索引的范围
        for (int i = 0; i < num.length - 2; i++) {
            //重复的跳过
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                //lo=第二个元素的索引,hi=最后一个元素的索引,要找的目标为sum
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                //如果没有相遇
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    @Test
    public void test1() {
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    @Test
    public void test2() {
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
    }
}
