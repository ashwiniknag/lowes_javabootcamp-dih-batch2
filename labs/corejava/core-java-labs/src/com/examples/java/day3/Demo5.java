package com.Ashwini.class3;


class Book {
    public String title;
    public String author;
    public int price;

    public void printBookInfo() {
        System.out.println("Book : Title =" + title +", author =" + author + ", price =" + price);
    }
}

public class Demo5 {
    public static void main(String[] args) {
        Book bookobj1 = new Book();
        bookobj1.title = "Learn Java";
        bookobj1.author = "Mr Smith";
        bookobj1.price = 500;

        Book bookobj2 = new Book();
        bookobj2.title = "Learn Dotnet";
        bookobj2.author = "Mrs Smith";
        bookobj2.price = 400;

        bookobj1.printBookInfo();
        bookobj2.printBookInfo();

    }
}
