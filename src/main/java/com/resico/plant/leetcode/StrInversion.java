package com.resico.plant.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author Airey
 * @since 2022/3/28 17:42
 */
public class StrInversion {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String target= scanner.nextLine();
        String reverse=strInverison(target);
        System.out.println(reverse);

    }

    /**
     * 字符串反转
     *
     * @param str
     */
    public static String strInverison(String str) {
        return (new StringBuilder(str)).reverse().toString();
    }

}
