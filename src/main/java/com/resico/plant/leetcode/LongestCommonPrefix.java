package com.resico.plant.leetcode;

import java.util.stream.Stream;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        Solution solution = new LongestCommonPrefix().new Solution();

        String[] strs = new String[]{"flow", "flowStr", "flsdfd"};
        String s = solution.longestCommonPrefix(strs);
        System.out.println(s);
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String prex = "";
            for (int i = 0; i < strs.length; i++) {
                if (i == 0) {
                    prex = strs[i];
                } else {
                    prex = compare(prex, strs[i]);
                }
            }
            return prex;
        }


        public String compare(String str1, String str2) {
            StringBuilder builder = new StringBuilder();
            int length = Math.min(str1.length(), str2.length());
            for (int i = 0; i <= length - 1; i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    builder.append(str1.charAt(i));
                } else {
                    break;
                }
            }
            return builder.toString();
        }
    }

}
