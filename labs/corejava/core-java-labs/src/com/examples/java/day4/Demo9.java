package com.Ashwini.class4;
class Car{
    public final int speedLimit = 50;

    public void drive(){
        //speedLimit = 70;
        System.out.println("The car is driving at speed of " + speedLimit);
    }
}
public class Demo9 {
    public static void main(String[] args) {
        Car car1 = new Car();
       //car1.speedLimit = 80;
        car1.drive();

    }
}
