package com.resico.plant.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AviatorDev {


    private static final Pattern ALPH_NUM_PAT = Pattern.compile("[0-9]+|[A-Z]+");


    public static void main(String[] args) {

        //SUM(A1,B1)

        //SUM(A1:B5) -> SUM(A1:A2,A3)


        //SUM(A1:D1)  -> SUM(A1,B1,C1,D1)

        //SUM(A1,B2:F2,K2);


        String expression = "SUM(A1,B2:F2,K2)";

        System.out.println(expression);
        System.out.println(getExpression(expression));


    }

    public static String getExpression(String expression) {
        if (expression.contains("SUM") && expression.contains(":")) {
            int start = expression.indexOf('(');
            int middle = expression.indexOf(':');
            int end = expression.indexOf(')');
            String firstWord = expression.substring(start + 1, middle);
            String secondWord = expression.substring(middle + 1, end);
            if (firstWord.contains(",") && secondWord.contains(",")) {
                String[] split1 = firstWord.split(",");
                firstWord = split1[split1.length - 1];
                String[] split2 = secondWord.split(",");
                secondWord = Arrays.stream(split2).findFirst().get();
                List<String> result = processWords(firstWord, secondWord);
                String replaceStr = firstWord + ":" + secondWord;
                return expression.replace(replaceStr, String.join(",", result));
            } else {
                List<String> result = processWords(firstWord, secondWord);
                System.out.println("list=" + result);
                String replaceStr = expression.substring(start + 1, end);
                return expression.replace(replaceStr, String.join(",", result));
            }
        }
        return expression;
    }

    /**
     * 处理分隔后的2个目标字符串
     *
     * @param firstWord
     * @param secondWord
     * @return
     */
    private static List<String> processWords(String firstWord, String secondWord) {
        ArrayList<String> result = new ArrayList<>();
        List<String> str1 = parse(firstWord);
        String s1 = str1.get(0);
        Integer f1 = Integer.valueOf(str1.get(1));
        List<String> str2 = parse(secondWord);
        String s2 = str2.get(0);
        Integer f2 = Integer.valueOf(str2.get(1));
        if (s1.length() == 1) {
            char index = s1.charAt(0);
            if (s2.length() == 1) {
                for (; index <= s2.charAt(0); index++) {
                    result.addAll(singular(index, f1, f2));
                }
            } else {
                for (; index <= 90; index++) {
                    result.addAll(singular(index, f1, f2));
                }
                String temp = "AA";
                result.addAll(dual(temp, s2, f1, f2));
            }
        }
        if (s1.length() == 2) {
            if (s2.length() == 1) {
                throw new RuntimeException("表达式有误,请检查");
            } else {
                result.addAll(dual(s1, s2, f1, f2));
            }
        }
        return result;
    }

    /**
     * 处理1个字母的循环
     *
     * @param index
     * @param f1
     * @param f2
     * @return
     */
    private static List<String> singular(char index, Integer f1, Integer f2) {
        ArrayList<String> result = new ArrayList<>();
        if (f1.equals(f2)) {
            String target = index + String.valueOf(f1);
            result.add(target);
        } else {
            for (int j = f1; j <= f2; j++) {
                String target = index + String.valueOf(j);
                result.add(target);
            }
        }
        return result;
    }

    /**
     * 处理2个字母的循环
     *
     * @param s1
     * @param s2
     * @param f1
     * @param f2
     * @return
     */
    private static List<String> dual(String s1, String s2, Integer f1, Integer f2) {
        ArrayList<String> result = new ArrayList<>();
        char m1 = s2.charAt(0);
        char m2 = s2.charAt(1);
        for (char k1 = s1.charAt(0); k1 <= m1; k1++) {
            for (char k2 = s1.charAt(1); k2 <= m2; k2++) {
                if (f1.equals(f2)) {
                    String target = k1 + "" + k2 + "" + f1;
                    result.add(target);
                } else {
                    for (int j = f1; j <= f2; j++) {
                        String target = k1 + "" + k2 + "" + j;
                        result.add(target);
                    }
                }
            }
        }
        return result;
    }


    /**
     * 分隔字符串
     *
     * @param str
     * @return
     */
    private static List<String> parse(String str) {
        List<String> parts = new ArrayList<>();
        Matcher matcher = ALPH_NUM_PAT.matcher(str);
        while (matcher.find()) {
            parts.add(matcher.group());
        }
        return parts;
    }


}
