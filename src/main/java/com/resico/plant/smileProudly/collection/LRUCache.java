package com.resico.plant.smileProudly.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * LRU 最近最少使用缓存淘汰算法
 * @author Airey
 * @date 2023/2/11 12:09
 */
public class LRUCache<K, V> implements Iterable<K> {


    int MAX = 3;
    LinkedHashMap<K, V> cacheMap = new LinkedHashMap<>();


    public void cache(K key, V value) {

        if (cacheMap.containsKey(key)) {
            cacheMap.remove(key);
        } else if (cacheMap.size() >= MAX) {
            Iterator<K> iterator = cacheMap.keySet().iterator();
            K first = iterator.next();
            cacheMap.remove(first);
        }


        cacheMap.put(key, value);


    }

    @NotNull
    @Override
    public Iterator<K> iterator() {
        Iterator<K> it = cacheMap.keySet().iterator();
        return new Iterator<K>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public K next() {
                return it.next();
            }
        };
    }

    public static void main(String[] args) {

        LRUCache<String, Integer> cache = new LRUCache<>();
        cache.cache("A",1);
        cache.cache("B",1);
        cache.cache("C",1);
        cache.cache("D",1);

        String collect = StreamSupport.stream(cache.spliterator(), false).collect(Collectors.joining(","));
        System.out.println("collect="+collect);

        System.out.println(Runtime.getRuntime().availableProcessors());


    }


}
