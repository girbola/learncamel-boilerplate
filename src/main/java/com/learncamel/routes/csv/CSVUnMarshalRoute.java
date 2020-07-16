package com.learncamel.routes.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.learncamel.domain.Employee2;

public class CSVUnMarshalRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		DataFormat bindy = new BindyCsvDataFormat(Employee2.class);
		
		from("file:data/csv/input?fileName=file1.txt&noop=true")
		.unmarshal(bindy)
		.log("UnMarshall MEssages is ${body}")
		.to("direct:output");
	}

}
