package com.resico.plant.list;

import com.resico.plant.bean.Person;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Airey
 * @since 2022/8/31 17:01
 */
public class ListForEachDev {

    public static void main(String[] args) {


        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        arrayList.forEach(integer -> {
            if (integer % 2 == 0) {
                return;
            } else {
                System.out.println("23243241324");
            }
        });

        Person person=new Person(1,"shikui","地址1");
        Person person1=new Person(1,"shikui","地址1");







    }

}
