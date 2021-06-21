package com.resico.plant.basicMathCourse.huangshen;

/**
 * @author Airey
 * @date 2021/6/15 17:37
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class MathRecursion {


    public static void main(String[] args) {
        int n = 8;
        div(true, n, String.valueOf(1));
        for (int i = 2; i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            div(false, n / i, String.valueOf(i));
        }
    }

    public static void div(boolean haveOne, int n, String s) {
        if (!haveOne) {
            if (n == 1) {
                System.out.println(s + "x" + 1);
                return;
            }
            div(true, n, s + "x" + 1);
        }
        for (int i = 2; i <= n; i++) {
            if (i == n) {
                System.out.println(s + "x" + n);
            } else if (n % i == 0) {
                div(haveOne, n / i, s + "x" + i);
            }
        }
    }

}
