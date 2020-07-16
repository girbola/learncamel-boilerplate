package com.learncamel.routes.fixedlength;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.EmployeeWithFixedLength;

public class FixedLengthMarshalRouteTest extends CamelTestSupport {


	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new FixedLengthMarshalRoute();
	}
	
	@Test
	public void fixedMarshalTest() throws InterruptedException {
		EmployeeWithFixedLength employeeWithFixedLength = new EmployeeWithFixedLength();
		employeeWithFixedLength.setId(1);
		employeeWithFixedLength.setName("Dilip");
		employeeWithFixedLength.setRole("Engineer");
		employeeWithFixedLength.setAge(30);
		employeeWithFixedLength.setJoiningDate(LocalDate.now());
		employeeWithFixedLength.setSalery(new BigDecimal("10000.00"));
		
		template.sendBody("direct:input", employeeWithFixedLength);
		
		Thread.sleep(2000);
		File file = new File("data/fixedlength/output");
		assertTrue(file.isDirectory());
		
	}
}
