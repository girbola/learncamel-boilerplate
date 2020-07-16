package com.learncamel.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Employee;

public class UnMarshalUsingXStreamTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new UnMarshalUsingXStream();
	}

	@Test
	public void unMarshalXstreamTest() throws InterruptedException {
		Employee employee = new Employee();
		employee.setJoinDate("12JAN2017");
		employee.setName("Daniel");
		employee.setId("124");
		
		String xmlInput = "<employee><id>124</id><name>Daniel</name><joinDate>12JAN2017</joinDate></employee>";
		
		MockEndpoint endPoint = getMockEndpoint("mock:output");
		endPoint.expectedBodiesReceived(employee.toString());
		template.sendBody("direct:xmlInput", xmlInput);
		
		assertMockEndpointsSatisfied();
	}

}
