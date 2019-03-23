package com.framework.spring.core.bean;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

import com.framework.spring.core.PrintMessageEvent;

/**
 * 集合注入
 * 方式四：Annotation标注init与destroy方法 @PostConstruct；@PreDestroy
 * MessageSource: 剥离静态代码（字符串）；internationalization
 * EventHandling.publish Event :1、implements ApplicationEventPublisher; 2、eventPublisher.publishEvent(new Event(this))
 * @author Administrator
 *
 * ApplicationEventPublisherAware: handler for AplicationEventPublisher
 */
public class ComplexObject implements ApplicationEventPublisherAware {

	private Properties adminEmails;
	private List someList;
	private Set someSet;
	private Map someMap;
	
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private MessageSource messageSource;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	
	public Properties getAdminEmails() {
		return adminEmails;
	}
	public void setAdminEmails(Properties adminEmails) {
		this.adminEmails = adminEmails;
	}
	public List getSomeList() {
		return someList;
	}
	public void setSomeList(List someList) {
		this.someList = someList;
	}
	public Set getSomeSet() {
		return someSet;
	}
	public void setSomeSet(Set someSet) {
		this.someSet = someSet;
	}
	public Map getSomeMap() {
		return someMap;
	}
	public void setSomeMap(Map someMap) {
		this.someMap = someMap;
	}
	

	public void printMessage(){
		System.out.println(messageSource.getMessage("greeting", null, "default message!", null));
		System.out.println("For English: " + messageSource.getMessage("complexObject.access", new Object[]{adminEmails.getProperty("administrator"),adminEmails.getProperty("support")}, "default message!", null));
		System.out.println("For Chinese: " + messageSource.getMessage("complexObject.access_cn", new Object[]{adminEmails.getProperty("administrator"),adminEmails.getProperty("support")}, "default message!", Locale.CHINESE));
		//publish event
		eventPublisher.publishEvent(new PrintMessageEvent(this));
	}
	
	
	@PostConstruct
	public void postconstruct(){
		System.out.println(messageSource.getMessage("complexObject.init", null, "default message!", null));
	}
	
	@PreDestroy
	public void preDestroy(){
		System.out.println(messageSource.getMessage("complexObject.destroy", null, "default message!", null));
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.eventPublisher = publisher;
	}
	
	
}
