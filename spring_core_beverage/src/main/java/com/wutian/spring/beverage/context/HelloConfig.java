package com.wutian.spring.beverage.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
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
}