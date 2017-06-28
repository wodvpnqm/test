package com.qm.algorithms.algothrim264;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wodvpn on 2017/4/23.
 */
public class Solution {
    /**
     * 只包含2,3,5
     * 包含了任何其他素数
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int [] primes = {7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
                67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137,
                139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211,
                223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283,
                293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379,
                383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461,
                463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563,
                569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643,
                647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739,
                743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829,
                839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937,
                941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021,
                1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093,
                1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181,
                1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259,
                1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321,
                1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433,
                1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493,
                1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579,
                1583, 1597, 1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657,
                1663, 1667, 1669};
        int numOfNonUglyNum = 0;
        int index = 0;
        int num = n;
        while(primes[index] <= num)
        {
            numOfNonUglyNum += num /primes[index];
            index++;
        }
        //总共n个数-非丑陋数字=丑陋数字个数
        int nThNumber = n - numOfNonUglyNum;
        int currentNum = n+1;
        while(nThNumber < n)
        {
            if(isUgly(currentNum)) {
                nThNumber++;
            }
            currentNum++;
        }
        return --currentNum;
    }

    public boolean isUgly(int num) {
        if(num<=0) return false;
        if(num==1) return true;

        while(num>=2 && num%2==0) num/=2;
        while(num>=3 && num%3==0) num/=3;
        while(num>=5 && num%5==0) num/=5;

        return num==1;
    }


    public boolean isPrime(int num)
    {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    @Test
    public void test() {
        //Assert.assertTrue(nthUglyNumber(10) == 12);
        Assert.assertTrue(nthUglyNumber(1) == 1);
        Assert.assertTrue(nthUglyNumber(2) == 2);
        Assert.assertTrue(nthUglyNumber(3) == 3);
        Assert.assertTrue(nthUglyNumber(4) == 4);
        Assert.assertTrue(nthUglyNumber(5) == 5);
        Assert.assertTrue(nthUglyNumber(6) == 6);
        Assert.assertTrue(nthUglyNumber(7) == 8);
        Assert.assertTrue(nthUglyNumber(8) == 9);
        Assert.assertTrue(nthUglyNumber(9) == 10);
        Assert.assertTrue(nthUglyNumber(10) == 12);
        Assert.assertTrue(nthUglyNumber(11) == 15);
        Assert.assertTrue(nthUglyNumber(12) == 16);
        Assert.assertTrue(nthUglyNumber(13) == 18);
    }

    @Test
    public void test1() {
        //Assert.assertTrue(nthUglyNumber(10) == 12);
        Assert.assertTrue(nthUglyNumber(7) == 8);
    }

    @Test
    public void test2() {
        //Assert.assertTrue(nthUglyNumber(10) == 12);
        Assert.assertTrue(nthUglyNumber(77) == 729);
    }



}
