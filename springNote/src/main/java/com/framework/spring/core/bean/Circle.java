package com.framework.spring.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

/**
 * Annotation：Autowired、Required、Qualifier
 * @author Administrator
 *
 */
public class Circle implements Shape{
	
	private String color;
	private int radius;
//	@Autowired //也可直接在成员变量上加Autowire标签
	private Point center;
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	//Required Annotation, Autowired Annotation(先按类型匹配——此类型对象唯一，再按名称匹配）, 在context内登记相关类
	@Required
	@Autowired  //autowire 方式一：按类型名称匹配成员变量
	@Qualifier("circleCenter")	//autowire 方式二：在符合bean内配置qualifier
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing " + getColor() + " circle with center Point of (" + center.getX() + ","+ center.getY() +"), radius of "+ getRadius() );
	}

}
