package com.learncamel.routes.gson;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

import com.learncamel.domain.Employee;

public class MarshalUsingGson extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);
		
		from("direct:marshalGSON")
		.log("Before Marshalled Object is: ${body}")
		.marshal(gsonDataFormat)
		.log("After Marshalled Object is: ${body}");
		
	}

}
