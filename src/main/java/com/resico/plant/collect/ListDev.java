package com.resico.plant.collect;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Airey
 * @date 2020/9/7 13:43
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ListDev {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("中国银行");
        list.add("中国工商银行");
//        list.add("华夏银行");
        String bank = String.join(",", list);
        System.out.println("bank= "+bank);

        List<Long> longs=new ArrayList<>();
        longs.add(3242L);
        longs.add(322L);
        String join = StringUtils.join(longs,",");
        String[] split = join.split(",");
        List<String> strings = Arrays.asList(split);

        System.out.println(join);
        System.out.println(strings);

        System.out.println(Integer.MAX_VALUE-8);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);


    }
}
