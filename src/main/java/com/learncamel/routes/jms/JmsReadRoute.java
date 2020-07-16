package com.learncamel.routes.jms;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Dilip on 5/26/17.
 */
public class JmsReadRoute extends RouteBuilder {

	public void configure() throws Exception {

		from("activemq:queue:testQueue").to("log:?level=INFO&showBody=true").to("direct:readQueue");

	}
}