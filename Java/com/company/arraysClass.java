package com.company;

import java.util.Arrays;

public class arraysClass {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        int index= Arrays.binarySearch(a,4);
        System.out.println("Index of element 4 in array "+index);
        for(int i=0;i<a.length;i++)
        {
            a[i]=(int)Math.floor(Math.random()*10+1);
        }
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        Arrays.fill(a,5);//a will be filled with 5
        System.out.println(Arrays.toString(a));
    }
}
