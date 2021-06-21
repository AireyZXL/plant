package com.resico.plant.leetcode;

import java.util.Arrays;

/**
 * @author Airey
 * @date 2021/6/17 17:30
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class RunningSumOf1dArray {

    public static void main(String[] args) {
        Solution solution = new RunningSumOf1dArray().new Solution();
        int [] nums= {3,1,2,10,1};
        int[] ints = solution.runningSum(nums);
        System.out.println(Arrays.toString(ints));

    }

    class Solution {
        public int[] runningSum(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sum = nums[i];
                }else {
                    sum = sum + nums[i];
                    nums[i]=sum;
                }
            }
            return nums;
        }
    }

}
