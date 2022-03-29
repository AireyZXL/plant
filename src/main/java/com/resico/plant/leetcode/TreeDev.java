package com.resico.plant.leetcode;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Airey
 * @date 2021/11/30 9:23
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class TreeDev {
    public static void main(String[] args) {


        int num = 'Z';
        System.out.println(num);

        List<String> arr = Arrays.asList("AK", "AA", "AB", "AC", "AD", "AE");
        List<String> arr2 = Arrays.asList("AK", "AA", "AB", "AC", "AD", "AE", "AF");
        List<String> arr3 = Arrays.asList("AX", "AY", "AZ", "BA", "BC", "BB", "GF");

        List<String> arr4 = Arrays.asList("#AA-AA", "#AA-AB" );
        List<String> arr6 = Arrays.asList("AX", "AY", "AZ", "BC", "BB", "GF");
        List<String> arr5 = Arrays.asList("AA");
        List<String> arr7 = Arrays.asList("CX","CY","CZ","DA","DD");
        ArrayList<String> list = new ArrayList<>(arr4);

        List<String> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println("collect=" + collect);

        int lastPosition = getLastPosition(collect);
        String s = collect.get(lastPosition);
        System.out.println("s=" + s);

    }


    public static int getLastPosition(List<String> layerNumberList) {
        List<Character> secondCharList = layerNumberList.stream().map(item -> item.charAt(item.length() - 1)).collect(Collectors.toList());
        List<Character> firstCharList = layerNumberList.stream().map(item -> item.charAt(item.length() - 2)).collect(Collectors.toList());
        int index = 0;
        for (int i = 0; i < secondCharList.size(); i++) {
            int j = i + 1;
            if (j == secondCharList.size()) {
                index = i;
                break;
            }
            int f1 = firstCharList.get(i);
            int f2 = firstCharList.get(j);
            int s1 = secondCharList.get(i);
            int s2 = secondCharList.get(j);
            if (f1 == f2) {
                if (s2 != s1 + 1) {
                    index = i;
                    break;
                }
            } else {
                if (!(s1 == 90 && f2 == f1 + 1 && s2 == 65)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}
