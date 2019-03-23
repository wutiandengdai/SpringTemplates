package com.microservice.webclient.entity;

import java.io.Serializable;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long amount;
	private String number;
	private String name;
	private transient String password;
	
	public Account(Long amount, String name, String number) {
		super();
		this.amount = amount;
		this.name = name;
		this.number = number;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Account [amount=" + amount + ", number=" + number + ", name=" + name + "]";
	}
	
}
