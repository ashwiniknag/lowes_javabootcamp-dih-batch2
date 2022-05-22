package com.examples.java.day7;

public class Demo5 {
    public static void main(String[] args) {
        char[] srcArray = { 'h', 'e', 'l', 'l','o'};
        char[] destArray = new char[4];

        System.arraycopy(srcArray, 0, destArray,0,4);
        System.out.println(String.valueOf(destArray));

    }
}
