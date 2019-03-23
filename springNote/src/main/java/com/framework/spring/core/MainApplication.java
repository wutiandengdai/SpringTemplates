package com.framework.spring.core;

import java.util.Enumeration;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.framework.spring.core.bean.ComplexObject;
import com.framework.spring.core.bean.Movie;
import com.framework.spring.core.bean.Rectangle;
import com.framework.spring.core.bean.Shape;
import com.framework.spring.core.bean.Triangle;

/**
 * Context initialization;
 * Main method;
 * context.getMessage Method
 * @author Administrator
 *
 */
public class MainApplication {

	public static void main(String[] args) {
		//方式一：文件位于项目根目录
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("applicationContext.xml"));
		//方式二，文件位于源码（src）根目录
//		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//方式三：AbstractApplicationContext注册shutdown
		AbstractApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		//call destroy method
		factory.registerShutdownHook();
//		Triangle triangle = (Triangle) factory.getBean("triangle-alias");
//		triangle.draw();
//		
//		//仅暴露接口，运行时决定实现
//		Shape shape = (Shape) factory.getBean("rectangle");
//		shape.draw();
		
		//集合注入
		ComplexObject co= (ComplexObject) factory.getBean("complexObject");
		co.printMessage();
//		Properties props = co.getAdminEmails();
//		Enumeration e = props.propertyNames();
//		while(e.hasMoreElements()){
//			String key = (String) e.nextElement();
//			System.out.println(key + " : " + props.getProperty(key));
//		}
//		for(Object o: co.getSomeList()){
//			System.out.println(o);
//		}

//		Movie movie1 = (Movie) factory.getBean("movie1");
//		Movie movie2 = (Movie) factory.getBean("movie2");
//		System.out.println("Movie1: " + movie1);
//		for(String s: movie1.getActors()){
//			System.out.println(s);
//		}
//		System.out.println("Movie2: " + movie2);
//		for(String s: movie2.getActors()){
//			System.out.println(s);
//		}
//		
		//Message 与国际化 ：1、context.getMessage; 2、Autowire messageSource byType(complexObject)
		String greeting = factory.getMessage("greeting", null, "default message", null);
		System.out.println(greeting);
		
		factory.close();
	}

}
