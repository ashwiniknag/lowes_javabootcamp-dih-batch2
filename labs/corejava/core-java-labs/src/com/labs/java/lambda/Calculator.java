package com.labs.java.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Calculator{
    public static void main(String[] args) {
        ICalculator add=(a,b) -> a + b;
        ICalculator sub=(a,b) -> a - b;
        ICalculator mul=(a,b) -> a * b;
        ICalculator div=(a,b) -> a / b;

       //BiFunction<Integer,Integer,Integer> add =(a,b) -> { System.out.println(a+b); return a+b;};

        System.out.println("20+10 "+doCalculate(20,10,add));
         System.out.println("20-10 "+doCalculate(20,10,sub));
        System.out.println("20*10 "+doCalculate(20,10,mul));
        System.out.println("20/10 "+doCalculate(20,10,div));



    }

    private static int doCalculate(int a ,int b,ICalculator operation)
    {
        return operation.calculate(a,b);
    }

    public interface ICalculator{
     public int calculate(int a,int b);
    }
}
