package com.resico.plant.smileProudly.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Airey
 * @date 2023/2/11 11:27
 */
public class RandomStringGenerator<T> implements Iterable<T>{


    private List<T> list;

    public RandomStringGenerator(List<T> list) {
        this.list = list;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                return list.get((int) (list.size()*Math.random()));
            }
        };
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("list", "set", "map");

        RandomStringGenerator<String> random = new RandomStringGenerator<>(list);
        for (String str:random){
            System.out.println(str);
        }

        Iterator<String> iterator = random.iterator();


    }
}
