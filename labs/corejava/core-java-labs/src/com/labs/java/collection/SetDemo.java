package com.labs.java.collection;

import java.util.HashSet;
import java.util.TreeSet;


public class SetDemo {
    public static void main(String[] args) {
        HashSet<String> countries = new HashSet<>();
        countries.add("India");
        countries.add("Japan");
        countries.add("Australia");
        countries.add(null);
        countries.add("India");
        countries.add("Japan");

        for(String str1 :countries) {
            System.out.println(str1);
        }
        System.out.println("Treeset output");
        TreeSet<String> countries1 = new TreeSet<>();
        countries1.add("India");
        countries1.add("Japan");
        countries1.add("Australia");
        countries1.add(null);
        countries1.add("India");
        countries1.add("Japan");

        for(String str1 :countries1) {
            System.out.println(str1);
        }
    }
}
