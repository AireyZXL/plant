package com.resico.plant.leetcode;

/**
 * @author Airey
 * @date 2021/6/21 11:03
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ShuffleString {

    public static void main(String[] args) {
        Solution solution = new ShuffleString().new Solution();

        String s = "aaiougrt";
        int[] indices = new int[]{4, 0, 2, 6, 7, 3, 1, 5};
        String s1 = solution.restoreString(s, indices);
        System.out.println(s1);
    }


    class Solution {
        public String restoreString(String s, int[] indices) {

            char[] chars = s.toCharArray();
            char[] m = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                m[indices[i]] = chars[i];
            }
            return String.valueOf(m);
        }
    }

}
