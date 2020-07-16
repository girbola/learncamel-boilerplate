package com.learncamel.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

@FixedLengthRecord(ignoreTrailingChars = true)
public class EmployeeWithFixedLength {

	@DataField(pos = 1, length = 3)
	private int id;
	@DataField(pos = 2, length = 10, trim = true, align = "L")
	private String name;
	@DataField(pos = 3, length = 8)
	private String role;
	@DataField(pos = 4, length = 16, pattern = "ddMMyyyy")
	private LocalDate joiningDate;
	@DataField(pos = 5, length = 2, delimiter = "^")
	private int age;
	@DataField(pos = 6, length = 8, precision = 2)
	private BigDecimal salery;

	public BigDecimal getSalery() {
		return salery;
	}

	public void setSalery(BigDecimal salery) {
		this.salery = salery;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public int getAge() {
		return age;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeeWithFixedLength [id=" + id + ", name=" + name + ", role=" + role + ", joiningDate="
				+ joiningDate + ", age=" + age + ", salery=" + salery + "]";
	}

}
