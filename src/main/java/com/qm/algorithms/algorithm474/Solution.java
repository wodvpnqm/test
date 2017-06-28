package com.qm.algorithms.algorithm474;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        List<int[]> inputs = getZeroOnes(strs);
        return inner(inputs,m,n,0);

    }

    public int inner(List<int[]> inputs,int m,int n,int level)
    {
        if(m < 0 || n < 0)
        {
            return 0;
        }
        if(level == inputs.size())
        {
            return 0;
        }
        int [] currentItem = inputs.get(level);
        int excludeMax = inner(inputs,m,n,level+1);
        int includeMax = 0;
        if(m >=0 && n>= 0 && m >= currentItem[0] && n >= currentItem[1])
        {
            includeMax = 1+inner(inputs,m-currentItem[0],n-currentItem[1],level+1);
        }
        return  Math.max(excludeMax,includeMax);
    }

    public List<int[]> getZeroOnes(String [] str)
    {
        List<int []> result = new ArrayList<>();
        for(int i=0;i<str.length;i++)
        {
            result.add(getZeroOne(str[i]));
        }
        return result;
    }

    public int[] getZeroOne(String str)
    {
        int [] result = new int[2];
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) == '0')
            {
                result[0]++;
            }else{
                result[1]++;
            }
        }
        return result;
    }

    @Test
    public void test()
    {
        String [] array = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 4;
        int n = 3;
        System.out.println(findMaxForm(array,m,n));
    }


    public void print(List<int []> lst)
    {
        for(int i=0;i<lst.size();i++)
        {
            System.out.print(Arrays.toString(lst.get(i)));
        }
        System.out.println();
    }
    @Test
    public void test1()
    {
        String [] array = new String[]{"10", "0", "1"};
        int m = 1;
        int n = 1;
        System.out.println(findMaxForm(array,m,n));
    }

    @Test
    public void test3()
    {
        String [] array = new String[]{ "0", "1"};
        int m = 1;
        int n = 1;
        System.out.println(findMaxForm(array,m,n));
    }

    @Test
    public void test4()
    {
        String [] array = new String[]{ "00", "000"};
        int m = 1;
        int n = 10;
        System.out.println(findMaxForm(array,m,n));
    }

    @Test
    public void test2()
    {
        String [] array = new String[]{"10","0001","111001","1","0"};
        int m = 4;
        int n = 3;
        System.out.println(findMaxForm(array,m,n));
    }
}
