package com.zxj.bean;

import com.zxj.annotation.UserResource;

@UserResource
public class User {
	
	private String name;
	
	public void study(){
		System.out.println(name + " 正在学习...");
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
