package com.labs.java.concurrency;

public class CreateThread01 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread Name - " + Thread.currentThread().getName());
        DemoThread01 t1 = new DemoThread01();
        t1.setName("t1");
        t1.setPriority(10);
        t1.start();
        t1.join(100);

        DemoThread01 t2 = new DemoThread01();
        t2.setName("t2");
        t2.setPriority(5);
        t2.start();
        t2.join();

        DemoThread01 t3 = new DemoThread01();
        t3.setName("t3");
        t1.setPriority(5);
        t3.start();
        t3.join();

        System.out.println("Exiting from main");
    }
}
