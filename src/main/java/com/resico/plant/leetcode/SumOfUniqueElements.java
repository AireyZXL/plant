package com.resico.plant.leetcode;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Airey
 * @date 2021/6/21 16:45
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class SumOfUniqueElements {

    public static void main(String[] args) {

        Solution solution = new SumOfUniqueElements().new Solution();

        int [] nums={1,2,3,4,5};
        int i = solution.sumOfUnique(nums);
        System.out.println(i);


    }

    class Solution {
        public int sumOfUnique(int[] nums) {

            int length = 101;

            int[] counter = new int[length];

            for (int num : nums) {
                counter[num]++;
            }

            int sum = 0;

            for (int i = 0; i < length; i++) {
                if (counter[i] == 1) {
                    sum += i;
                }
            }

            return sum;
        }
    }


}
