package com.Ashwini.class3;

class Book1 {
    public String title;
    public String author;
    public int price;

    public Book1(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;

    }

    public void printBookInfo() {
        System.out.println("Book : Title = " + title + ", author = " + author + ", price = " + price);
    }
}

public class Demo6 {
    public static void main(String[] args) {
        Book1 bobj1 = new Book1("java", "Mr John", 100);
                bobj1.printBookInfo();
    }
}
