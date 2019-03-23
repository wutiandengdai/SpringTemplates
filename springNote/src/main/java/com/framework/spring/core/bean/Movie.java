package com.framework.spring.core.bean;

import java.util.List;

/**
 * Bean - parent
 * 全局 init-method, destroy-method
 * @author Administrator
 *
 */
public class Movie{

	private String name;
	private int year;
	private float hours;
	private String director;
	private String country;
	private List<String> actors;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public List<String> getActors() {
		return actors;
	}
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", year=" + year + ", hours=" + hours + ", director=" + director + ", country="
				+ country + "]";
	}
	
	/**
	 * 方式二：注册初始化方法
	 */
	public void myInit(){
		System.out.println("Self defined init method of Movie called.");
	}
	
	public void cleanUp(){
		actors.clear();
		System.out.println("Selft defined destroy method of Movie called-----");
	}
}
