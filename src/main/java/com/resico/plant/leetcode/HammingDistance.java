package com.resico.plant.leetcode;

/**
 * @author Airey
 * @date 2021/6/16 14:34
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class HammingDistance {


    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
        int i = solution.hammingDistance(1, 4);
        System.out.println("汉明距离="+i);

    }

    class Solution {
        public int hammingDistance(int x, int y) {
            String s = Integer.toBinaryString(x);
            String s1 = Integer.toBinaryString(y);
            System.out.println(s);
            System.out.println(s1);
            int m;
            if (s.length() > s1.length()) {
                m = s.length() - s1.length();
                int k=m;
                for (int i = 0; i < s1.length(); i++) {
                    if (s.charAt(i+k) != s.charAt(i)) {
                        m++;
                    }
                }
            } else {
                m = s1.length() - s.length();
                int k=m;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != s1.charAt(i+k)) {
                        m++;
                    }
                }
            }
            return m;
        }
    }
}
