package com.examples.java.day8;

public class Demo5 {
    public static void main(String[] args) {
        //case 1 - Exception does not occur
        try {
            int c = 10 / 5;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Case 1 : finally called");
        }

        //case 2 - Exception occurred but not handled
        try {
            int c = 10 / 0;
            System.out.println(c);
        } catch (Exception ex) {
        } finally {
            System.out.println(" Case2 : finally called");
        }
        //case 3 - Exception occurred and handled
        try {
            int c = 10 / 0;
            System.out.println(c);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Case3: finally called");
        }
    }
}
