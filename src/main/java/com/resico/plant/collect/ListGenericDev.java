package com.resico.plant.collect;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @author Airey
 * @date 2021/4/9 17:11
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ListGenericDev {


    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

        list.getClass().getMethod("add", Object.class).invoke(list, "asd");

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
