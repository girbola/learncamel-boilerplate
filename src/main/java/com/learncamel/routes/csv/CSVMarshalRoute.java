package com.learncamel.routes.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.learncamel.domain.Employee2;

public class CSVMarshalRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		DataFormat bindy = new BindyCsvDataFormat(Employee2.class);

		from("direct:objInput").log("Received MEssages is ${body}").marshal(bindy).log("Marshalled Message is ${body}")
				.to("file:data/csv/output?fileName=output.txt");

	}

}
