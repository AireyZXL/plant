package com.resico.plant.leetcode;

import java.util.Scanner;

public class IsPalindrome {


    public static void main(String[] args) {

        Solution solution = new IsPalindrome().new Solution();
        int x = 10;
        boolean palindrome = solution.isPalindrome(x);
        System.out.println(palindrome);

    }

    class Solution {
        public boolean isPalindrome(int x) {
            String m = String.valueOf(x);
            char[] chars = m.toCharArray();
            boolean flag = true;
            for (int i = 0; i <= (chars.length - 1) / 2; i++) {
                if (chars[i] != chars[chars.length - 1 - i]) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }

}
