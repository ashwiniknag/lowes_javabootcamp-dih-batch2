package com.labs.spring.core;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpringMaven1 {
    public static void main(String[] args) {
        System.out.println("Hello World Spring");
/*
        Greetings greetings = new Greetings("Welcome to spring core");
        System.out.println(greetings.getMsg());
        greetings.setMsg("Hello Spring!!!!");
        System.out.println(greetings.getMsg());*/
        //step1 - create instance of IOC container
        ApplicationContext ctx =new ClassPathXmlApplicationContext("beans-config.xml");
        // ApplicationContext ctx =new FileSystemXmlApplicationContext("C:\\Users\\Ashwini\\Training\\lowes_javabootcamp-dih-batch2\\labs\\hello-world-spring\\hello-world-spring\\src/beans-config.xml");
        System.out.println(ctx);
        System.out.println("no of beans - " + ctx.getBeanDefinitionCount());

        com.labs.spring.core.Greetings greetings = ctx.getBean("greetings", com.labs.spring.core.Greetings.class);
        System.out.println(greetings.getMsg());

        com.labs.spring.core.Greetings greetings1 = ctx.getBean("greetings1", com.labs.spring.core.Greetings.class);
        System.out.println(greetings1.getMsg());

        com.labs.spring.core.Greetings greetings2 = ctx.getBean("greetings2", com.labs.spring.core.Greetings.class);
        System.out.println(greetings2.getMsg());

    }
}
