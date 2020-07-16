package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

public class Employee {

	private String id;
	private String name;
	private String joinDate;


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", joinDate=" + joinDate + "]";
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getJoinDate() {
		return joinDate;
	}


	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

}
