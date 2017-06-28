package com.qm.algorithms.algorithm363;

import org.junit.Test;

import java.util.TreeSet;

/**
 * Created by wodvpn on 2017/4/24.
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = 0;
        if (m > 0) n = matrix[0].length;
        if (m * n == 0) return 0;

        int M = Math.max(m, n);
        int N = Math.min(m, n);

        int ans = Integer.MIN_VALUE;
        for (int x = 0; x < N; x++) {
            int sums[] = new int[M];
            for (int y = x; y < N; y++) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                int num = 0;
                for (int z = 0; z < M; z++) {
                    sums[z] += m > n ? matrix[z][y] : matrix[y][z];
                    num += sums[z];
                    if (num <= k) ans = Math.max(ans, num);
                    Integer i = set.ceiling(num - k);
                    if (i != null) ans = Math.max(ans, num - i);
                    set.add(num);
                }
            }
        }
        return ans;
    }


    public static int maxSumSubmatrix1(int[][] matrix, int target) {
        //行数
        int row = matrix.length;
        //行不能等于0
        if (row == 0)
            return 0;
        //列数
        int col = matrix[0].length;
        //列不能等于0
        if (col == 0)
            return 0;
        //结果
        int result = Integer.MIN_VALUE;
        //保证从小
        boolean key = col > row ? false : true;
        //小的
        int m = Math.min(row, col);
        //大的
        int n = Math.max(row, col);
        //一行一行的找
        for (int i = 0; i < m; i++) {
            //找从第i行开始一直到第0行这i+1行的可能组成的矩形长度
            int[] array = new int[n];//这个矩阵为了保存每一列上第j行到第i行的和
            for (int j = i; j >= 0; j--) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                //用来保存当前高度下，长度为从0开始到k位置的矩形的结果。理解set的含义是解决此题的关键。
                set.add(0);
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    if (key) {
                        array[k] += matrix[k][j];
                    } else {
                        array[k] += matrix[j][k];
                    }
                    sum += array[k];
                        /* 因为要满足  （sum-set中的元素）<=target,
                         * 而且sum-set中的元素的值要尽可能的大，
                         * 所以也就是再求小于等于sum-target中满足条件的元素的最小的一个
                         * 正好TreeSet中提供了这个方法ceil()，可以很方便的找出这个元素
                         */
                    Integer integer = set.ceiling(sum - target);
                    if (integer != null) {
                        result = Math.max(result, sum - integer);
                    }
                    set.add(sum);
                }

            }
        }
        return result;
    }


        public int maxSumSubmatrix2(int[][] matrix, int k) {
            //和矩阵
            int[][] vsum = new int[matrix.length][matrix[0].length];
            //对每一行
            for(int i = 0; i < matrix.length; i++) {
                //对每一列
                for(int j = 0; j < matrix[i].length; j++) {
                    //复制到sum
                    vsum[i][j] = matrix[i][j];
                    if (i > 0) vsum[i][j] += vsum[i-1][j];
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < matrix.length; i++) {
                for(int j = i; j < matrix.length; j++) {
                    TreeSet<Integer> ts = new TreeSet<Integer>();
                    int sum = 0;
                    for(int m = 0; m < matrix[i].length; m++) {
                        sum += vsum[j][m];
                        if (i > 0) sum -= vsum[i-1][m];
                        if (sum == k) return sum;
                        if (sum < k) max = Math.max(max, sum);
                        Integer other = ts.ceiling(sum - k);
                        // System.out.printf("i=%d, j=%d, m=%d, sum=%d, ts=%s\n", i, j, m, sum, ts);
                        ts.add(sum);
                        if (other == null) continue;
                        max = Math.max(max, sum - other);
                    }
                }
            }
            return max;
        }


    @Test
    public void test() {
        int[][] matrix = new int[2][];
        matrix[0] = new int[]{1, 0, 1};
        matrix[1] = new int[]{0, -2, 3};
        System.out.println(maxSumSubmatrix2(matrix, 2));
    }

    @Test
    public void test1() {
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{2, 2, -1};
        System.out.println(maxSumSubmatrix(matrix, 0));
    }

    /*
    [[2,2,-1]]
0
     */
}
