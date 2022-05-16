package com.Ashwini.class3;

class Car{
    public String brand;
    public String year;
    public String model;
    public String color;
    public String engineType;
    public int price;

    public Car(String brand, String year, String model, String color, String engineType, int price) {
        this.brand = brand;
        this.year = year;
        this.model = model;
        this.color = color;
        this.engineType = engineType;
        this.price = price;

    }

    public Car(Car car) {
        this.brand = car.brand;
        this.year = car.year;
        this.model = car.model;
        this.color = car.color;
        this.engineType = car.engineType;
        this.price = car.price;
    }

    public Car(Car car, int price) {
        this.brand = car.brand;
        this.year = car.year;
        this.model = car.model;
        this.color = car.color;
        this.engineType = car.engineType;
        this.price = price;

    }
}

public class Demo9 {
    public static void main(String[] args) {
        Car car1 =new Car("Hyundai", "2016", "i20", "white", "Petrol", 500000);
        Car car2 =new Car(car1);
        Car car3 =new Car(car1, 20000);

    }
}
