package com.learncamel.routes.xml2json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XML2JSONRouteTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new XML2JSONRoute();
	}

	@Test
	public void marshalEmployee2JSONXML() {

		String expected = "{\"id\":\"123\",\"name\":\"dilip\",\"joinDate\":\"12JAN2017\"}";

		String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>dilip</name><joinDate>12JAN2017</joinDate></employee>";

		String response = template.requestBody("direct:marshalEmployeexml2json", input, String.class);

		System.out.println("1111111111Response: " + response);

		assertEquals(expected, response);
	}

	@Test
	public void unMarshalEmployeejson2XML() {

		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<Employee><id>123</id><joinDate>12JAN2017</joinDate><name>dilip</name></Employee>\r\n" + 
				"";
		String input = "{\"id\":\"123\",\"name\":\"dilip\",\"joinDate\":\"12JAN2017\"}";

		String response = template.requestBody("direct:unMarshalEmployee2json", input, String.class);

		System.out.println("222222Response: " + response);

		assertEquals(expected, response);

	}

}
