package com.framework.spring.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/** 1、@Entity table
 * 2、@Id primary key
 * 3、@ManyToOne relation tables
 * @author Administrator
 *
 */
//to tell jpa create a table mapping to this class
@Entity 
public class Topic {
	//from javax.persistence , to tell jpa what the primary key is
	@Id
	private int id;
	private String name;
	private String description;
	
	public Topic() {
		super();
	}

	public Topic(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
