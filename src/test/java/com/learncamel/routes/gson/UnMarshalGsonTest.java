package com.learncamel.routes.gson;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Employee;

public class UnMarshalGsonTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new UnMarshalUsingGson();
	}

	@Test
	public void unMarshalGson() {

		Employee employee;

		String input = "{\"id\":\"1\",\"name\":\"Dilip\",\"joinDate\":\"12Jan2017\"}";

		employee = (Employee) template.requestBody("direct:unMarshalGSON", input);

		assertEquals("1", employee.getId());
	}
}
