package com.labs.java.concurrency;

public class DemoThread02 implements Runnable{
 //   @override
    public void run(){

        for(int i=0; i<10;i++)
        {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
