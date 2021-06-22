package com.resico.plant.leetcode;

/**
 * @author Airey
 * @date 2021/6/21 16:59
 * ----------------------------------------------
 * 1512 好数对的数目
 * ----------------------------------------------
 */
public class NumberOfGoodPairs {


    public static void main(String[] args) {

        Solution solution = new NumberOfGoodPairs().new Solution();
        int[] nums = {1, 1,1,1};
        int i = solution.numIdenticalPairs(nums);
        System.out.println(i);


    }


    class Solution {
        public int numIdenticalPairs(int[] nums) {

            int sum = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] == nums[j]) {
                        sum++;
                    }
                }
            }
            return sum;
        }
    }

}
