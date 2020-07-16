package com.learncamel.routes.process;

import org.apache.camel.builder.RouteBuilder;

import com.learncamel.processor.CamelDirectExampleProcessor;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:processorInput")
		.log("Received Message before process ${body} and headers are ${headers}")
		.process(new CamelDirectExampleProcessor())
		.log("Received Message after process ${body} and headers are ${headers}")
		//.to("file:data/output?fileName=output.txt");
		.to("mock:output");
	}

}
