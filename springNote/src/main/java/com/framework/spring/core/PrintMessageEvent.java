package com.framework.spring.core;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author Administrator
 *
 */
public class PrintMessageEvent extends ApplicationEvent{

	public PrintMessageEvent(Object source) {
		super(source);
		
	}
	
	public String toString(){
		return "Print Message Event triggered.";
	}

}
