package com.labs.java.java8;

public interface DefaultDemo {

    static void StaticPrint(){
        System.out.println("Static implementation");

    }
    default void DefaultPrint(){
        System.out.println("Default implementation");
        PrivatePrint();
    }

   private void PrivatePrint(){
        System.out.println("Private Default implementation");

    }


}
