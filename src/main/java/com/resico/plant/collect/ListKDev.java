package com.resico.plant.collect;

import cn.hutool.core.util.ObjectUtil;
import com.resico.plant.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Airey
 * @date 2021/5/12 16:27
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ListKDev {


    public static void main(String[] args) {
        List<Person> list=new ArrayList<Person>();

        List<String> collect = list.stream().filter(item -> ObjectUtil.isNotNull(item.getAge())).map(Person::getName).collect(Collectors.toList());
        List<String> collect1 = list.stream().map(Person::getName).collect(Collectors.toList());


        List<Person> collect2 = list.stream().filter(item -> !collect1.contains(item.getName())).collect(Collectors.toList());

    }



}

