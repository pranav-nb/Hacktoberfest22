package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class priorityQueue {
    public static void main(String[] args) {
        Queue<Integer> pr=new PriorityQueue<>(Comparator.reverseOrder());
        pr.offer(44);
        pr.offer(12);
        pr.offer(24);
        pr.offer(36);
        pr.offer(5);
        System.out.println(pr);
        pr.poll();
        System.out.println(pr);
        //smallest element comes to first index for coming out of queue
        pr.poll();
        System.out.println(pr);
        System.out.println(pr.peek());
    }
}
