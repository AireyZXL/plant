package com.resico.plant.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Airey
 * @date 2021/6/22 10:11
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ZiFuChuanDePaiLieLcof {

    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();

        String[] abcs = solution.permutation("abcde");
        System.out.println(Arrays.toString(abcs));
    }

    class Solution {

        List<StringBuilder> temp;
        List<String> res;


        public String[] permutation(String s) {
            temp = new ArrayList<>();
            res = new ArrayList<>();
            if (s.length() != 0) {
                temp.add(new StringBuilder(Character.toString(s.charAt(0))));
            }
            for (int i = 1; i < s.length(); i++) {
                insert(s.charAt(i));
            }
            temp.stream().distinct().forEach(item -> res.add(item.toString()));
            res = res.stream().distinct().collect(Collectors.toList());
            return res.toArray(new String[0]);
        }


        public void insert(Character character) {
            List<StringBuilder> str = new ArrayList<>();
            temp.forEach(item -> {
                for (int i = 0; i <= item.length(); i++) {
                    StringBuilder sb = new StringBuilder(item);
                    sb.insert(i, character);
                    str.add(sb);
                }
            });
            temp = str;
        }


    }
}
