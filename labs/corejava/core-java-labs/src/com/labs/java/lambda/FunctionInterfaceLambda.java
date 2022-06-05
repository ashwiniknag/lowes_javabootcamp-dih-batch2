package com.labs.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionInterfaceLambda {
    public static void main(String[] args) {

        //consumer -> take arguments no return

    Consumer<String> consumer = (msg) -> System.out.println(msg);
    consumer.accept("Hello Consumer");

    //consumer -> take arguments no return
    BiConsumer<String,String> biConsumer = (msg1,msg2)  -> System.out.println(msg1 + " " + msg2);
    biConsumer.accept("Hello", "Lambda");


    //supplier ->no argument and return value
    Supplier<List> supplier = () -> Arrays.asList("Java","Spring","Hibernate");
       System.out.println(supplier.get());

    //function -> take argument and return
    Function<Integer, String> function =(a) -> {if ( a % 2  == 0) return "even"; else return "odd";};
    System.out.println(function.apply(10));

    UnaryOperator<Integer> unary = (a) -> a*2;
    System.out.println(unary.apply(10));

    BinaryOperator<Integer> binary =(a,b) -> (a+b) *2;
    System.out.println(binary.apply(10,20));


}
}