package com.examples.java.day6;

public class Demo4 {
    public static void main(String[] args) {
    StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());

        sb.append("Hello");
        System.out.println(sb.capacity());

        sb.append("Hello to java world");
        System.out.println(sb.capacity());

    }
}
