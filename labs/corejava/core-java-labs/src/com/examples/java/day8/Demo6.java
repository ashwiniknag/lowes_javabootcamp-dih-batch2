package com.examples.java.day8;

public class Demo6  {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void doSomething() throws Exception {
        doSomethingElse();
    }
    public static void doSomethingElse() throws Exception {
        doSomethingSomethingElse();
    }
    public static void doSomethingSomethingElse() throws Exception {
        throw new Exception();

    }

}
