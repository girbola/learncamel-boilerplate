package com.learncamel.routes.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyBeanRouteTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		System.out.println("This is routebuilder");
		return new CamelModifyBeanRoute();
	}
	
	
	@Test
	public void beanTest() {
		System.out.println("This is beanTest start");
		String expected = "123*dilip*12JAN2017";
		String input = "123,dilip,12JAN2017";
		
		System.out.println("This is beanTest before actual");
		String actual = (String) template.requestBody("direct:beanInput", input);
		System.out.println("This is beanTest actual value: " + actual);
		assertEquals(expected, actual);
		System.out.println("This is beanTest and assertion is done");
	}

}
