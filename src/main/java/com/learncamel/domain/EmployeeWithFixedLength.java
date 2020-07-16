package com.learncamel.domain;

import java.time.LocalDate;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

@FixedLengthRecord(ignoreTrailingChars = true)
public class EmployeeWithFixedLength {
	@DataField(pos = 1, length = 3)
	private String id;
	@DataField(pos = 2, length = 10, trim = true, align = "L")
	private String firstName;
	@DataField(pos = 3, length = 8)
	private String role;
	@DataField(pos = 4, length = 9, pattern = "ddMMMyyyy")
	private LocalDate joiningDate;

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "EmployeeWithFixedLength [id=" + id + ", firstName=" + firstName + ", role=" + role + ", joiningDate="
				+ joiningDate + "]";
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getRole() {
		return role;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
