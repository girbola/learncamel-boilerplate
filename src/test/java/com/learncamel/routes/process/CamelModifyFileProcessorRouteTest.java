package com.learncamel.routes.process;

import java.io.File;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.routes.process.CamelModifyFileProcessorRoute;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new CamelModifyFileProcessorRoute();
	}

	
	@Test
	public void processorTest() throws InterruptedException {
		String expectedValue = "123:dilip:12JAN2017\r\n" + 
				"345:marko:12JAN2017";
		
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expectedValue);
		
		Thread.sleep(5000);
		
		File file = new File("data/output");
		
		assertTrue(file.isDirectory());
		
		assertMockEndpointsSatisfied();
		
	}
}
