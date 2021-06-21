package com.resico.plant.leetcode;

import java.util.Arrays;

/**
 * @author Airey
 * @date 2021/6/17 16:48
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ReplaceAllDigitsWithCharacters {

    public static void main(String[] args) {

        String s="a1b2c3z4e";
        Solution solution = new ReplaceAllDigitsWithCharacters().new Solution();
        String s1 = solution.replaceDigits(s);
        System.out.println(s1);

    }

    class Solution {
        public String replaceDigits(String s) {

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 != 0) {
                    int k = Integer.parseInt(String.valueOf(chars[i]));
                    int m = chars[i - 1] + k;
                    if (m > 122) {
                        m = 122;
                    }
                    chars[i]= (char) m;
                }
            }
            return String.valueOf(chars);
        }


    }
}
