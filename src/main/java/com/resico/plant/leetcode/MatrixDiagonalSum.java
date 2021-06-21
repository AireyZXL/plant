package com.resico.plant.leetcode;

/**
 * @author Airey
 * @date 2021/6/16 17:03
 * ----------------------------------------------
 * 矩阵对角线元素之和
 * ----------------------------------------------
 */
public class MatrixDiagonalSum {

    public static void main(String[] args) {
        Solution solution = new MatrixDiagonalSum().new Solution();

        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7,8,9}};
        int i = solution.diagonalSum(mat);
        System.out.println(i);

    }

    class Solution {
        public int diagonalSum(int[][] mat) {
            int sum = 0;
            if (mat.length == 1) {
                return mat[0][0];
            }
            for (int i = 0; i < mat.length; i++) {
                if (mat.length % 2!= 0) {
                    if ( i == mat.length / 2){
                        sum += mat[i][i];
                    }else {
                        sum += mat[i][i] + mat[i][mat.length - 1 - i];
                    }
                } else {
                    sum += mat[i][i] + mat[i][mat.length - 1 - i];
                }
            }
            return sum;
        }
    }

}
