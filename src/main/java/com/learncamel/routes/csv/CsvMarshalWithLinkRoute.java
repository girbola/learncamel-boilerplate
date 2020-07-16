package com.learncamel.routes.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.learncamel.domain.EmployeeWithAddress;

public class CsvMarshalWithLinkRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

			DataFormat bindy = new BindyCsvDataFormat(EmployeeWithAddress.class);
			
			from("direct:objInput")
			.marshal(bindy)
			.log("Marshaled message is ${body}")
			.to("file:data/csv/output?fileName=outputWithAddress.txt");
	}

}