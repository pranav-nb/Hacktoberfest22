package com.company;

import java.util.Stack;

public class learnStack {
    public static void main(String[] args) {
        Stack<String> animals=new Stack<>();
        animals.push("Lion");
        animals.push("dog");
        animals.push("horse");
        animals.push("Cat");
        System.out.println("Stack : "+animals);
        System.out.println(animals.peek());
        animals.pop();
        System.out.println(animals);
        animals.pop();
        System.out.println(animals);
    }
}
