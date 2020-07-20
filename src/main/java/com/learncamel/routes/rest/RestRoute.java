package com.learncamel.routes.rest;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class RestRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
//		 from("direct:restCall")
//         .to("log:?level=INFO&showBody=true")
//         .setHeader(Exchange.HTTP_METHOD, constant("GET"))
//         .setHeader(Exchange.HTTP_URI, simple("https://restcountries.eu/rest/v2/alpha/${body}"))
//         .to("http://restcountries.eu/rest/v2/alpha/${body}")
//         .to("log:?level=INFO&showBody=true");
		from("direct:start")
		  .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http.HttpMethods.POST))
		  .to("http://www.google.com")
		  .to("mock:results");

	}

}
