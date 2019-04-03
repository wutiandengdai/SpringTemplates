package com.wutian.spring.beverage.context;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * With @Configuration, no @Bean at getter needed
 */
// @Configuration
class HelloConfig {

    private String header;
    private String name;

    public HelloConfig(){
        System.out.println("New Instance.");
    }

    public HelloConfig(String header, String name){
        this.header = header;
        this.name=name;
        System.out.println("New Instance.");
    }

    @Bean
    public String sayHello() {
        return "Hello !";
    }

    public void greeting(){
        System.out.println(this.header + " " + this.name + "!");
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
        System.out.println(context.getBean("greeting"));

        ((AbstractApplicationContext) context).close();
    }

    /**
     * The method called after properties are set on all beans
     */
    @PostConstruct
    public void init(){
        System.out.println(" Class " + HelloConfig.class.getName() + " inited!");
    }

    /**
     * Excuted when ApplicationContext closes
     */
    @PreDestroy
    public void destry(){
        System.out.println(" Class " + HelloConfig.class.getName() + " destroyed!");
    }
}