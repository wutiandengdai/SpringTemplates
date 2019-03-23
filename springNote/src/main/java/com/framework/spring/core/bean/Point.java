package com.framework.spring.core.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 方式一：初始化与销毁回调
 * 重点1：factory采用AbstractApplicationContext声明；重点2：对factory进行 registerShutdownHook，否则destroy方法不会被调用
 * @author Administrator
 *
 */
public class Point  implements InitializingBean, DisposableBean{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Method (InitializingBean) called in Point...");
	}
	public void destroy() throws Exception {
		System.out.println("Point Bean (DisposableBean) destroyed...");
	}
}
