package com.resico.plant.hutool;

import cn.hutool.core.util.NumberUtil;

/**
 * @author Airey
 * @date 2021/12/7 11:37
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class NumberDev {
    public static void main(String[] args) {

        String s="232343234221321";
        String s1="23234323422132";
        boolean number = NumberUtil.isNumber(s);

        boolean aLong = NumberUtil.isLong(s);

        System.out.println(number);
        System.out.println(aLong);


        Long aLong1 = Long.valueOf(s);
        Long aLong2 = Long.valueOf(s1);

        int compare = Long.compare(aLong1, aLong2);

        System.out.println(compare);


    }
}
