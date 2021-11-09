package com.resico.plant.hutool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Airey
 * @date 2021/7/15 16:17
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ForTest {

    public static void main(String[] args) {


        List<List<String>> list = new ArrayList<>();

        ArrayList<String> strings = new ArrayList<>();
        strings.add("123");
        strings.add("345");
        strings.add("456");
        strings.add("567");

        list.add(strings);


        ArrayList<String> strings2 = new ArrayList<>();
        strings.add("abc");
        strings.add("def");
        strings.add("edf");
        strings.add("ade");
        list.add(strings2);

        list.forEach(itemList -> {

            if (CollUtil.isNotEmpty(itemList)) {
                for (String e : itemList) {
                    if ("abc".equals(e)) {
                        System.out.println("中奖了");
                        break;
                    } else {
                        System.out.println(e);
                    }
                }
            }

        });


    }


}
