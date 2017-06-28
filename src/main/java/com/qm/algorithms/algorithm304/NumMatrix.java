package com.qm.algorithms.algorithm304;

/**
 * Created by wodvpn on 2017/4/25.
 */
public class NumMatrix {

    private int [][] matrix;
    private int [][] colSum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.colSum = new int[matrix.length][];
        for(int i=0;i<colSum.length;i++)
        {
            colSum[i] = new int[matrix[0].length];
        }
        init();
    }

    private void init() {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                colSum[i][j] = j>0?(colSum[i][j-1] + matrix[i][j]):matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for(int i=row1;i<=row2;i++)
        {
            result += (colSum[i][col2] - (col1>0?colSum[i][col1-1]:0));
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] multi = new int[][]{
                { 1,2 },
                {2,3 }
        };
        NumMatrix nm = new NumMatrix(multi);
        System.out.println(nm.sumRegion(0,0,1,1));


    }
}
