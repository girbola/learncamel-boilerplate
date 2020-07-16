package com.learncamel.routes.csv;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Employee2;

public class CSVUnMarshalRouteTest extends CamelTestSupport {

	@Override
	public RoutesBuilder createRouteBuilder() {
		return new CSVUnMarshalRoute();
	}
	
	@Test
	public void CSVunMarshalRoute() throws InterruptedException {
		Exchange exchange = consumer.receive("direct:output");
		Thread.sleep(5000);
		
		List<Employee2> employees = (List<Employee2>) exchange.getIn().getBody();
		assertEquals("dilip", employees.get(0).getFirstName());
		assertEquals("marko", employees.get(1).getFirstName());
		
	}
}
