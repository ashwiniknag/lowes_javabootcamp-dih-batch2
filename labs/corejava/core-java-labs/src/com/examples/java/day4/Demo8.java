package com.Ashwini.class4;
class A10{
    static int a;

    static{
        a=20;
        System.out.println(a);
    }

    public void test1(){
        a=30;
        System.out.println(a);
    }
}
public class Demo8 {
    public static void main(String[] args) {
         A10 a1 = new A10();
         a1.test1();

    }
}
