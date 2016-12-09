package com.zxj.annotationTest;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.zxj.annotation.UserResource;
import com.zxj.bean.Student;
import com.zxj.bean.User;

public class StudentTest {

	private User user;
	
	@Before
	public void before() throws ClassNotFoundException, SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException{
		Class<?> cls = Class.forName("com.zxj.bean.User", true, ClassLoader.getSystemClassLoader());
		UserResource userRes = cls.getAnnotation(UserResource.class);
		if(userRes == null){
			throw new NullPointerException();
		}
		user = (User) cls.newInstance();
		user.setName(userRes.value());
	}
	
	@Test
	public void fieldElementType() throws SecurityException, NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> cls = Class.forName("com.zxj.bean.Student", true, ClassLoader.getSystemClassLoader());
		Student student = (Student) cls.newInstance();
		Field field = Student.class.getDeclaredField("user");
		UserResource userRes = field.getAnnotation(UserResource.class);
		if(userRes == null){
			throw new NullPointerException("Student类——属性user——没有userResource注解");
		}
		student.setUser(user);
		System.out.println(student);
	}
}
