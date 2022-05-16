package com.Ashwini.class4;

class Bike{
    public final void drive(){
        System.out.println("Driving.....");

    }
}

class Honda extends Bike{
    @Override
    public void drive(){
        System.out.println("stop");
    }
}
public class Demo11 {
    public static void main(String[] args) {
        Honda H = new Honda();
        H.drive();

    }
}
