package com.examples.java.day5;

import java.util.Arrays;

public class Demo8 {
    public static void main(String[] args) {
        String str1 = "mark@gmail.com";
        String[] result = str1.split("@");
        System.out.println(Arrays.toString(result));

    }
}
