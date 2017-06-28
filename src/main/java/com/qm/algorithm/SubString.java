package com.qm.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wodvpn on 2017/4/26.
 */
public class SubString {

    public List<String> subString(String input)
    {
        List<String> result = new ArrayList<String>();
        dfs(result,input,0,new StringBuilder());
        return result;
    }

    public void dfs(List<String> result,String input,int level,StringBuilder current)
    {
        if(level == input.length())
        {
            if(current.length() > 0)
            {
                result.add(current.toString());
            }
            return;
        }
        dfs(result,input,level+1,current);
        current.append(input.charAt(level));
        dfs(result,input,level+1,current);
        current.deleteCharAt(current.length()-1);
    }

    @Test
    public void test()
    {
        System.out.println(subString("11"));
    }

    public int subString1(String input)
    {
        int length = input.length();
        int [] tail = new int[length+1];
        int [] all = new int[length+1];
        tail[0] = 0;
        all[0] = 0;
        for(int i=0;i<length;i++) {
            tail[i + 1] = tail[i]+1;
            all[i + 1] = tail[i + 1] + all[i];
        }
        return all[length];
    }

    public List<String> subString2(String input)
    {
        int length = input.length();
        int [] tail = new int[length+1];
        int [] all = new int[length+1];
        List<String> tailList = new ArrayList<String>();
        List<String> allList = new ArrayList<String>();
        tail[0] = 0;
        all[0] = 0;
        for(int i=0;i<length;i++) {
            int tailLength =  tailList.size();
            for(int j=0;j<tailLength;j++)
            {
                String first = tailList.remove(0);
                tailList.add(first+input.charAt(i));
            }
            tailList.add(input.charAt(i)+"");
            allList.addAll(tailList);
        }
        return allList;
    }

    @Test
    public void test1()
    {
        //1,2,3,4,12,23,34,123,234,1234
        System.out.println(subString1("123"));
    }

    @Test
    public void test2()
    {
        //1,2,3,4,12,23,34,123,234,1234
        //System.out.println(subString2("1234"));
        //System.out.println(subString2("1"));
        System.out.println(subString2(""));
    }



}
