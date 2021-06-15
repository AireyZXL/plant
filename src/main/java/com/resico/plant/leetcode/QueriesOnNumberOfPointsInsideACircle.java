package com.resico.plant.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Airey
 * @date 2021/5/31 15:29
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class QueriesOnNumberOfPointsInsideACircle {

    public static void main(String[] args) {
        Solution solution = new QueriesOnNumberOfPointsInsideACircle().new Solution();

        int[][] points = new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] ints = solution.countPoints(points, queries);
        System.out.println(Arrays.toString(ints));
    }


    class Solution {

        public int[] countPoints(int[][] points, int[][] queries) {

            int[] countArr = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {

                int count = 0;
                int x = queries[i][0];
                int y = queries[i][1];
                int r = queries[i][2];

                for (int k = 0; k < points.length; k++) {
                    int px = points[k][0];
                    int py = points[k][1];
                    if ((Math.pow((x - px), 2) + Math.pow((y - py), 2)) <= Math.pow(r, 2)) {
                        count++;
                    }
                }
                countArr[i] = count;
            }
            return countArr;
        }
    }

}

