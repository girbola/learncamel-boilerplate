package com.learncamel.bean;

public class CamelBean {
	
	public String map(String input) {
		System.out.println("111MAP: " + input);
		String newBody = input.replace(",", "*");
		return newBody;
	}
	

	public String map1(String input) {
		System.out.println("222MAP1: " + input);
		String newBody = input.replace(",", "*");
		return newBody;
	}
}
