package com.framework.spring.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor, 需在Bean Context中定义
 * 全局调用（对所有注册Bean，包括内嵌bean）
 * @author Administrator
 *
 */
public class DisplayBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Post Process after Initializing Bean " + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Post Process before Initializing Bean " + beanName);
		return bean;
	}

}
