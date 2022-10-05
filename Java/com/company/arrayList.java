package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arrayList {

    public static void main(String[] args) {
//        ArrayList<Integer> students=new ArrayList<>();
//        students.add(2);
//        students.add(0,1);
//        System.out.println(students);
//        List<Integer> newList=new ArrayList<>();
//        newList.add(150);
//        newList.add(160);
//        System.out.println(students);
//        System.out.println(newList);
//        students.addAll(newList);
//        System.out.println(students);
        List<Integer> list=new ArrayList<>();
        for(int i=10;i<=80;i+=10)
        {
            list.add(i);
        }
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.remove(Integer.valueOf(60));
        System.out.println(list);
        list.clear();
        System.out.println(list);
        list.add(20);
        System.out.println(list);
        list.set(0,10);
        list.add(30);
        System.out.println(list);
        System.out.println(list.contains(30));
        for (int i = 0; i < list.size(); i++) {
            System.out.println("The element is "+list.get(i));
        }
        for (Integer element:list)
        {
            System.out.println("forEach element is "+element);
        }
        Iterator<Integer> it=list.iterator();
        while (it.hasNext())
        {
            System.out.println("iterator "+it.next());
        }
    }
}











