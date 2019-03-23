package com.framework.spring.core;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义 Event Listener —— 定义 Event触发事件
 * 1、applicationContext中注册； 2、implements ApplicationListener
 * @author Administrator
 *
 */
@Component
public class GeneralEventListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("EVENT TRIGERRED " + event.toString());
	}

}
