package com.resico.plant.collect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Airey
 * @date 2020/11/12 14:49
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ListValueDev {

    public static void main(String[] args) {

        List<LabelValue> list=new ArrayList<>();
        list.add(LabelValue.builder().name("1111").key(123).build());
        list.add(LabelValue.builder().name("2222").key(345).build());
        list.add(LabelValue.builder().name("3333").key(567).build());

        list.forEach(item->{
            item.setKey(789);
        });

        System.out.println(list);
    }



}
