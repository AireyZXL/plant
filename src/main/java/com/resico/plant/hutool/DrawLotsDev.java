package com.resico.plant.hutool;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Airey
 * @since 2022/6/10 14:38
 */
public class DrawLotsDev {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("赵世奎", "黄海", "谢中甯", "刘婷", "詹小雷", "邓鑫", "周旋");
        int i = RandomUtil.randomInt(0, 6);
        System.out.println("抽签结果=" + list.get(i));


    }


}
