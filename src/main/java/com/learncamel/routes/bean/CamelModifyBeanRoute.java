package com.learncamel.routes.bean;

import org.apache.camel.builder.RouteBuilder;

import com.learncamel.bean.CamelBean;

public class CamelModifyBeanRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		System.out.println("This is configure starting point");
		from("direct:beanInput").log("BEFORE bean is ${body}").bean(new CamelBean(), "map1"). // This is how you call
																								// specific method from
																								// class. Name has to
																								// match with it. If
																								// only one method then
																								// you don't need to
																								// call it separately
				log("AFTER bean MESSAGE is ${body}").to("mock:output");
	}

}
