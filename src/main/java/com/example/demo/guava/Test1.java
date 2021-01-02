package com.example.demo.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.eventbus.EventBus;
import com.sun.javafx.UnmodifiableArrayList;

import java.util.*;
import java.util.stream.Stream;

public class Test1 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[]args) {
//        EventBus;


        threadLocal.set(1);
        test();
        System.out.println(UUID.randomUUID());


//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(3);
//
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(3);
//        list2.add(4);
//
//        List<List<Integer>> list = Lists.newArrayList();
//        list.add(list1);
//        list.add(list2);
//
//        //扁平化
//        Stream<Integer> objectStream = list.stream().flatMap(Collection::stream).distinct();
//        System.out.println(Arrays.toString(objectStream.toArray()));
//
//        HashMap<String, String[]> map = Maps.newHashMap();
//        map.put("1",new String[]{"123","234"});
//        System.out.println(map);

//        System.out.println(Thread.currentThread().getId() + Thread.currentThread().getName());


        // 不可变模式
//        ImmutableList<Integer> immutableList = ImmutableList.copyOf(list);
//        UnmodifiableArrayList<Integer> ts = new UnmodifiableArrayList<Integer>((Integer[]) list.toArray(), list.size());

    }

    static void test(){
        System.out.println(threadLocal.get());
    }
//
//    static {
//        System.out.println(1);
//    }
//
//    static {
//        System.out.println(2);
//    }
}
