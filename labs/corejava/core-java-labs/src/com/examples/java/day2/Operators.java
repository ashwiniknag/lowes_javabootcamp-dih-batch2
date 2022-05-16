package com.Ashwini.class2;

public class Operators {
    public static void main(String[] args) {
        int a=30;
        int b =20;
        int c=10;
        boolean t = true;
        boolean f = false;

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);

        System.out.println(a>b);
        System.out.println(a>b && a>c);
        System.out.println(a>b && a<c);
        System.out.println(a>b || a<c);

        int num = (a<b)? a:b;
        System.out.println(num);


    }
}
