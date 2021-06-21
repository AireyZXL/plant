package com.resico.plant.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Airey
 * @date 2021/6/21 10:42
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class RichestCustomerWealth {


    public static void main(String[] args) {

        Solution solution = new RichestCustomerWealth().new Solution();

        int[][] accounts = {{1, 5}, {7, 3}, {3, 5}};
        int i = solution.maximumWealth(accounts);
        System.out.println(i);
        System.out.println(Integer.MIN_VALUE);

    }


    class Solution {
        public int maximumWealth(int[][] accounts) {

            int ans = Integer.MIN_VALUE;

            for (int i = 0; i < accounts.length; i++) {
                int sum = 0;
                for (int j = 0; j < accounts[i].length; j++) {
                    sum += accounts[i][j];
                }
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }

}
