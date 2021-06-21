package com.resico.plant.leetcode;

import java.util.Arrays;

/**
 * @author Airey
 * @date 2021/6/21 11:25
 * ----------------------------------------------
 * 1561   你可以获得最大的硬币数目
 * ----------------------------------------------
 */
public class MaximumNumberOfCoinsYouCanGet {


    public static void main(String[] args) {


        Solution solution = new MaximumNumberOfCoinsYouCanGet().new Solution();
        int[] piles = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        int i = solution.maxCoins(piles);
        System.out.println(i);

    }


    class Solution {
        public int maxCoins(int[] piles) {

            int sum = 0;
            Arrays.sort(piles);
            int k = piles.length / 3;
            for (int i = k; i < piles.length; i += 2) {
                sum += piles[i];
            }

            return sum;

        }
    }

}
