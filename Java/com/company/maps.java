package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class maps {
    public static void main(String[] args) {
//
//        Map<String,Integer> map=new HashMap<>();
//
//        map.put("one",1);
//        map.put("two",2);
//        map.put("three",3);
//        map.put("four",4);
//        map.put("five",5);
//        System.out.println(map);
//        for (Map.Entry<String,Integer> e: map.entrySet())
//        {
//            System.out.println(e.getKey());
//            System.out.println(e.getValue());
//        }
//        for (String key:map.keySet())
//        {
//            System.out.println(key);
//        }
//        for (Integer value:map.values())
//        {
//            System.out.println(value);
//        }
//        System.out.println(map.containsKey("six"));
//        System.out.println(map.containsValue(4));

        Map<String,Integer> map=new TreeMap<>();

        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put("e",5);
        System.out.println(map);
        for (Map.Entry<String,Integer> e: map.entrySet())
        {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        for (String key:map.keySet())
        {
            System.out.println(key);
        }
        for (Integer value:map.values())
        {
            System.out.println(value);
        }
        System.out.println(map.containsKey("six"));
        System.out.println(map.containsValue(4));
        map.remove("a");
        System.out.println(map);

    }
}
