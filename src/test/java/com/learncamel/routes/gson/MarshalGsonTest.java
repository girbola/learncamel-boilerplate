package com.learncamel.routes.gson;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Employee;
import com.learncamel.routes.gson.MarshalUsingGson;

public class MarshalGsonTest extends CamelTestSupport{

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new MarshalUsingGson();
	}

	@Test
	public void marshalUsingGson() {
		
		Employee employee = new Employee();
		employee.setId("1");
		employee.setName("Dilip");
		employee.setJoinDate("12Jan2017");
		
		String expected = "{\"id\":\"1\",\"name\":\"Dilip\",\"joinDate\":\"12Jan2017\"}";
		
		String employeeJson = template.requestBody("direct:marshalGSON", employee, String.class);
		
		System.out.println("employeeGSon: " + employeeJson);
		
		assertEquals(expected, employeeJson);
	}
}
