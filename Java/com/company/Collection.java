package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
       // List<Integer> list=new ArrayList<>();
//        for (int i=0;i<7;i++)
//        {
//            list.add((int)(Math.floor(Math.random()*10+1)));
//        }
//        System.out.println(list);
////        System.out.println("min element"+ Collections.min(list));
////        System.out.println("max element"+ Collections.max(list));
////        System.out.println("freq element"+ Collections.frequency(list,2));
//        Collections.sort(list, Comparator.reverseOrder());
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
        List<Student> list=new ArrayList<>();
        list.add(new Student("Vadi",1));
        list.add(new Student("Ram",5));
        list.add(new Student("Ani",3));
        list.add(new Student("Anuj",6));
        Collections.sort(list);
        System.out.println(list);
    }
}
