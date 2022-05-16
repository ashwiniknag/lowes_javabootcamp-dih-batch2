package com.Ashwini.class2;

public class Demo6 {
    public static void main(String[] args) {
        int score = 80;
        if(score==90)
            System.out.println("Excellent");
        else if(score < 90 && score > 75)
            System.out.println("Very Good");
        else if(score < 75 && score > 50)
            System.out.println("good");
        else
            System.out.println("Needs improvement");
    }
}
