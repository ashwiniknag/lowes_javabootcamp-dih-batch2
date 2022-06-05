package com.labs.java.concurrency;

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Hello world");

        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("Default");//set name
        Thread.currentThread().setPriority(10);//set priority of thread
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getState());
        System.out.println(Thread.currentThread().isDaemon());//background treads

    }
}
