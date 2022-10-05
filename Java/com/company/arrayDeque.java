package com.company;

import java.util.ArrayDeque;

public class arrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> adq=new ArrayDeque<>();
        adq.offer(23);
        adq.offerFirst(43);
        adq.offerLast(55);
        System.out.println(adq);
        adq.pollFirst();
        adq.offerLast(66);
        adq.offerLast(77);
        System.out.println(adq);
        adq.pollLast();
        System.out.println(adq);
        System.out.println(adq.peekFirst());
        System.out.println(adq.peekLast());
    }
}
