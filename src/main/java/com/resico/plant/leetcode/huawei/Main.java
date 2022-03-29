package com.resico.plant.leetcode.huawei;

import java.util.Scanner;

/**
 * @author Airey
 * @since 2022/3/28 17:53
 */
public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer target = scanner.nextInt();
        String result = function(target);
        System.out.println(result);

    }


    public static String function(Integer target) {

        StringBuilder builder = new StringBuilder();
        String s = target.toString();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }


}
