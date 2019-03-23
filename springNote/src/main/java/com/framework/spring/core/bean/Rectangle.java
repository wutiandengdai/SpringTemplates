package com.framework.spring.core.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * 通过applicationContext 内定义context：Component-scan自动扫描
 * Resource 注册bean、 PostConstruct, PreDestroy
 * @author Administrator
 *
 */
@Component
public class Rectangle implements Shape{

	private String color;
	private int width;
	private int height;
	private Point center;
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public Rectangle() {
		super();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Point getCenter() {
		return center;
	}

	//Resource方式注入 *名称与成员变量名相同时可省略name
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}

	//创建后， 需注册Hook factory.registerShutdownHook();
	@PostConstruct
	public void initializeShape(){
		System.out.println("After Rectangle initialized");
	}
	
	@PreDestroy
	public void destroyShape(){
		System.out.println("Before Rectangel Destroyed" );
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing " + getColor()+ " rectangle with size of " + getWidth() + " X " + getHeight()+ ", with center of "+ getCenter() );
		
	}

	@Override
	public String toString() {
		return "Rectangle [color=" + color + ", width=" + width + ", height=" + height + "]";
	}
	

}
