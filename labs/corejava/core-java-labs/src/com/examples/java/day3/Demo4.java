package com.Ashwini.class3;

public class Demo4 {
    public static void main(String[] args) {
        System.out.println("start");
        for(int i=0; i<10; i++) {
            if(i==5)
                continue;
            System.out.println(i);
        }
        System.out.println("end");
    }
}
