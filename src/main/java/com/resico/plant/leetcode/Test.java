package com.resico.plant.leetcode;

import java.util.Arrays;

/**
 * @author Airey
 * @date 2021/5/11 10:20
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Test().new Solution();
        int reverse = solution.reverse(1534236469);
        System.out.println(reverse);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {

            if (x > 0) {
                String s = String.valueOf(x);
                StringBuilder stringBuilder = new StringBuilder(s);
                Long integer = Long.valueOf(stringBuilder.reverse().toString());
                return integer.intValue();
            } else if (x < 0) {
                int y=Math.abs(x);
                String s=String.valueOf(y);
                StringBuilder stringBuilder=new StringBuilder(s);
                Long integer=Long.parseLong(stringBuilder.reverse().toString())*(-1);
                return integer.intValue();
            } else {
                return x;
            }


        }
    }




}
