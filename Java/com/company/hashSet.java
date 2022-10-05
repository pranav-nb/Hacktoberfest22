package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class hashSet {
    public static void main(String[] args) {

//        Set<Integer> set=new HashSet<>();
//        set.add(32);
//        set.add(2);
//        set.add(54);
//        set.add(21);
//        set.add(65);
//        set.add(76);
//        System.out.println(set);
//        set.remove(21);
//        System.out.println(set);
//        System.out.println(set.contains(21));
//        System.out.println(set.isEmpty());
//        System.out.println(set.size());
//        set.clear();
//        System.out.println(set.isEmpty());
//        Set<Integer> set=new LinkedHashSet<>();
//        set.add(32);
//        set.add(2);
//        set.add(54);
//        set.add(21);
//        set.add(65);
//        set.add(76);
//        System.out.println(set);
//        set.remove(21);
//        System.out.println(set);
//        System.out.println(set.contains(21));
//        System.out.println(set.isEmpty());
//        System.out.println(set.size());
//        set.clear();
////        System.out.println(set.isEmpty());
//        Set<Integer> set=new TreeSet<>();
//        set.add(32);
//        set.add(2);
//        set.add(54);
//        set.add(21);
//        set.add(65);
//        set.add(76);
//        System.out.println(set);
//        set.remove(21);
//        System.out.println(set);
//        System.out.println(set.contains(21));
//        System.out.println(set.isEmpty());
        Set<Student> studentSet=new HashSet<>();
        studentSet.add(new Student("Vadi",2));
        studentSet.add(new Student("Anuj",3));
        studentSet.add(new Student("ani",2));
        studentSet.add(new Student("Ram",7));
        System.out.println(studentSet);
    }
}
