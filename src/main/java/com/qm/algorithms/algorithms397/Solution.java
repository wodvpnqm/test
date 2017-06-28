package com.qm.algorithms.algorithms397;

import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/23.
 */
public class Solution {
    /**
     * 0111
     * 0110
     * 0011
     * 0010
     * 0001
     * <p>
     * <p>
     * 0010->
     *
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        int num = 0;
        while(n > 1)
        {
            if(n % 2 == 0)
            {
                num++;
                n = n/2;
                continue;
            }
            int a =countTrailZero(n-1);
            int b =countTrailZero(n+1);
            if(a > b)
            {
                num++;
                n--;
                continue;
            }else{
                num++;
                n++;
            }
        }
        return num;
    }


    public int numOf1(int n) {
        int count = 0;
        // 判断一个整数的二进制位中有多少个1
        while (n > 0) //这一句，当n不等于0的时候循环执行以下循环体，n等于0的变化条件在n>>=1这一句，将n左移一位，这样当n中所有的"1"位都移出时，就跳出循环了
        {
            if ((n & 1) == 1)  //这句逐个通过位与的方式查看当前n最左边的一位是不是1，若是，则n&1=1,c加1用来计数
                count++;
            n >>= 1;
        }
        return count;//这样循环结束时就能得到所需的1的个数了
    }

    public int countTrailZero(int n) {
        int c = 0;
        while ((n & 1) == 0) {
            n = n >> 1;
            c++;
        }
        return c;
    }

    // 判断一个整数的二进制位中有多少个1
    int  totalOne(int x)
    {
        int count = 0;
        while(x>0)
        {
            x = x & ( x - 1 );
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(numOf1(7));
        System.out.println(totalOne(7));
        //System.out.println(integerReplacement(65535));
    }

    @Test
    public void test1() {
        System.out.println(integerReplacement(3));
        //System.out.println(integerReplacement(65535));
    }
}
