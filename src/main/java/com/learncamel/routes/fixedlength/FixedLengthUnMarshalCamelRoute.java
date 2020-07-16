package com.learncamel.routes.fixedlength;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

import com.learncamel.domain.EmployeeWithFixedLength;

public class FixedLengthUnMarshalCamelRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);
		
		from("file:data/fixedlength/input?fileName=fixedlenght.txt&noop=true")
		.unmarshal(bindy)
		.log("UnMarshaled Message is ${body}")
		.to("direct:output");
		
	}

}
