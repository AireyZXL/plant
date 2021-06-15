package com.resico.plant.collect;

import com.resico.plant.bean.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Airey
 * @date 2021/2/26 10:16
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class MapDev {

    public static void main(String[] args) {


         List<Person> personList= new ArrayList<>();

         personList.add(Person.builder().age(154).name("Airey").build());
         personList.add(Person.builder().age(18).name("Kim").build());
         personList.add(Person.builder().age(16).name("San").build());

        Map<Integer, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getAge));

        Map<Integer, List<Person>> treeMap = new TreeMap<Integer, List<Person>>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        treeMap.putAll(collect);

        List<Person> collect1 = personList.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        System.out.println("collect1="+collect1);

        System.out.println("collect="+collect);
        System.out.println("treeMap="+treeMap);


        HashMap<String, Long> stringLongHashMap = new HashMap<>();
        if (stringLongHashMap.containsKey("1111")){
            System.out.println("111");
        }else {
            System.out.println("222");
        }

    }


}
