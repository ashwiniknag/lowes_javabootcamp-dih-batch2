package com.labs.spring.carapps;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

    public static void main(String[] args) {

        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        //AbstractApplicationContext ctx = new AnnotationConfigApplicationContext();

        System.out.println("No of beans: " + ctx.getBeanDefinitionCount());

        for(String beanName: ctx.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }


        //shut down context
        ctx.registerShutdownHook();

    }

}

