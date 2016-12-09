package com.zxj.bean;

import com.zxj.annotation.UserResource;

public class Student {

	@UserResource
	private User user;
	
	public void setUser(User user){
		this.user = user;
	}

	@Override
	public String toString() {
		return user.getName() + " is a student.";
	}
	
}
