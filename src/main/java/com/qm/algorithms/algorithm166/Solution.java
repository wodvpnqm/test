package com.qm.algorithms.algorithm166;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wodvpn on 2017/4/23.
 */
public class Solution {

    /**
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(long numerator, long denominator) {
        //1.如何判断是否是有限的还是无限的

        //边界排除
        if(numerator == 0)
        {
            return "0";
        }
        //正规化
        boolean negetive = Boolean.logicalXor(numerator<0,denominator<0);
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long gcd = gcd(numerator,denominator);
        numerator = numerator/gcd;
        denominator = denominator/gcd;

        Map<Long,Integer> digits = new HashMap<>();
        Long integerPart = null;
        long decimalPart = 1;
        //正整数除法
        if(numerator >= denominator)
        {
            integerPart = numerator/denominator;
            numerator = numerator % denominator;
            if(numerator == 0)
                return negetive?("-"+integerPart):(""+integerPart);
        }

        StringBuilder result = new StringBuilder();
        //到这里分子小于分母
        if (negetive) {
            result.append("-");
        }
        if(integerPart == null)
        {
            result.append("0.");
        }else{
            result.append(integerPart).append(".");
        }
        digits.put(numerator,result.length());
        while(numerator != 0)
        {
            //自动乘以10
            numerator *= 10;
            //1/100的情况下要多次乘以10
            while(numerator < denominator)
            {
                numerator *= 10;
                result.append("0");
            }
            integerPart = numerator/denominator;
            numerator = numerator % denominator;
            if(digits.containsKey(numerator))
            {
                result.append(")");
                break;
            }
            result.append(integerPart);
            digits.put(numerator,result.length());
        }
        if(numerator == 0)
        {
            return result.toString();
        }
        result.insert(digits.get(numerator)-1,"(");
        return result.toString();

    }

    /**
     *
     * (2,1)->(1,0)
     * (8,6)->(6,2)->(2,0)
     *(12,8)->(8,4)->(4,0)
     * 最大公约数
     * @param numerator 分子
     * @param denominator 分母
     * @return 最大公约数
     */
    public long gcd(long numerator,long denominator)
    {
        if(denominator == 0)
        {
            return numerator;
        }
        if(numerator < denominator)
        {
            return gcd(denominator,numerator);
        }
        return gcd(denominator,numerator % denominator);
    }

    @Test
    public void testGcd1()
    {
        Assert.assertTrue(gcd(1,1)==1);
        Assert.assertTrue(gcd(1,2)==1);
        Assert.assertTrue(gcd(2,2)==2);
        Assert.assertTrue(gcd(2,3)==1);
        Assert.assertTrue(gcd(3,6)==3);
        Assert.assertTrue(gcd(12,8)==4);
        Assert.assertTrue(gcd(24,18)==6);
        Assert.assertTrue(gcd(1000,100)==100);
        Assert.assertTrue(gcd(64,18)==2);
//(64,18)->(32,9)
    }

    @Test
    public void testFractionToDecimal()
    {
        System.out.println(fractionToDecimal(1,1));
        System.out.println(fractionToDecimal(1,2));
        System.out.println(fractionToDecimal(1,3));
        System.out.println(fractionToDecimal(1,4));
        System.out.println(fractionToDecimal(1,5));
        System.out.println(fractionToDecimal(1,6));
        System.out.println(fractionToDecimal(1,7));
        System.out.println(fractionToDecimal(1,8));
        System.out.println(fractionToDecimal(1,9));
        System.out.println(fractionToDecimal(1,10));
    }

    @Test
    public void testFractionToDecimal1()
    {
//        System.out.println(fractionToDecimal(-1,-2147483648));
//        System.out.println(fractionToDecimal(-2147483648,-1));
        System.out.println(fractionToDecimal(1,90));
    }


    @Test
    public void testDivide()
    {
        System.out.println((-1.0)/(-2147483648));
    }








}
