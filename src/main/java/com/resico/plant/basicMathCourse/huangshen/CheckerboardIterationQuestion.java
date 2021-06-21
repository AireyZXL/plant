package com.resico.plant.basicMathCourse.huangshen;

/**
 * @author Airey
 * @date 2021/6/15 15:26
 * ----------------------------------------------
 * 64格棋盘迭代问题
 * ----------------------------------------------
 */
public class CheckerboardIterationQuestion {

    public static void main(String[] args) {

        System.out.println("麦粒第63格总数="+getNumberOfWheat(63));


    }


    public static long getNumberOfWheat(int grid) {

        // 麦粒总数
        long sum = 0;
        // 当前格子里麦粒的数量
        long numberOfWheatInGrid = 0;
        numberOfWheatInGrid = 1;
        sum += numberOfWheatInGrid;
        for (int i = 2; i <= grid; i++) {
            numberOfWheatInGrid *= 2;
            sum += numberOfWheatInGrid;
        }
        return sum;

    }


}
