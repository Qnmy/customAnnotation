package com.zxj.annotationTest;

import java.util.Arrays;

import org.junit.Test;

import com.zxj.annotation.UserResource;
import com.zxj.bean.User;

public class UserTest {

	@Test
	public void userAnnotation() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> cls = Class.forName("com.zxj.bean.User", true, ClassLoader.getSystemClassLoader());
		UserResource userRes = cls.getAnnotation(UserResource.class);
		if(userRes == null){
			throw new NullPointerException();
		}
		System.out.println(userRes.value());
		User user = (User) cls.newInstance();
		user.setName(userRes.value());
		user.study();
		/**
		 * 注解接口的实例化对象所属类名(代理对象)
		 */
		System.out.println(userRes.getClass().getName());
		/**
		 * 注解接口对象类所实现的接口名(代理对象所实现的接口)
		 */
		System.out.println(Arrays.toString(userRes.getClass().getInterfaces()));
	}
}
