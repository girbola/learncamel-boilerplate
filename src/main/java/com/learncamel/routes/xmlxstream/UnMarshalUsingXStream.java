package com.learncamel.routes.xmlxstream;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import com.learncamel.domain.Employee;


public class UnMarshalUsingXStream extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		Map<String, String> aliases = new HashMap<>();
		aliases.put("employee", Employee.class.getName());
		
		XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
		xStreamDataFormat.setAliases(aliases);
		xStreamDataFormat.setPermissions(Employee.class.getName());
		
		from("direct:xmlInput")
		.unmarshal(xStreamDataFormat)
		.to("log:?level=INFO&showBody=true")
		.to("mock:output");
	}

}
