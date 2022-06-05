package com.labs.java.concurrency;

public class DemoThread01 extends Thread{
    public void run(){

        for(int i=0; i<10;i++)
        {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}
