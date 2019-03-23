package com.framework.spring.core.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring Depency Inject （setter、Constructor）
 * init、destroy 
 * ApplicationContextAware handler获取context； BeanNameAware获取beanName
 * @author Administrator
 *
 */
public class Triangle implements Shape, ApplicationContextAware, BeanNameAware {
	private String color;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private ApplicationContext context;
	
	public Triangle(){}
	
	public Triangle(String color){
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	@Override
	public void draw(){
		System.out.println("Point A: " + getPointA());
		System.out.println("Point B: " + getPointB());
		System.out.println("Point C: " + getPointC());
	}

	//Bean 名称 Aware
	public void setBeanName(String beanName) {
		System.out.println("bean Name is: " + beanName);
	}

	//此bean的上下文Aware
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		System.out.println("Application Context Set. Contains center bean: "+ context.containsBean("center"));
	}
	
	/**
	 * 方式三：applicationContext 内配置默认初始化方法
	 */
	public void init(){
		System.out.println("Default init in Triangle...");
	}
	public void destroy(){
		System.out.println("Default destroy in Triange...");
	}
}
