package com.resico.plant.leetcode;

/**
 * @author Airey
 * @date 2021/6/17 17:15
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ZuoXuanZhuanZiFuChuanLcof {

    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        String s="lrloseumgh";
        String s1 = solution.reverseLeftWords(s, 6);
        System.out.println(s1);
    }

    class Solution {
        public String reverseLeftWords(String s, int n) {
            String s1 = s.substring(0, n);
            String s2 = s.substring(n);
            s2 = s2 + s1;
            return s2;
        }
    }

}
