package com.Ashwini.class4;
class A{
    public void test1(){}

}
class  B extends A{
    public void test2(){}

}
class C extends B {
    public void test3(){}
}

public class Demo3 {
    public static void main(String[] args) {
   A a =new A();
   B b = new B();
   C c = new C();

   a.test1();

   b.test1();
   b.test2();

   c. test1();
   c.test2();
   c.test3();

    }
}
