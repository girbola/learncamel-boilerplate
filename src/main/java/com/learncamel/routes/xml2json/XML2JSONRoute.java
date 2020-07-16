package com.learncamel.routes.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;

public class XML2JSONRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("direct:marshalEmployeexml2json").to("log:?level=INFO&showBody=true").marshal().xmljson()
				.to("log:?level=INFO&showBody=true");

		XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
		xmlJsonDataFormat.setRootName("Employee");

		from("direct:unMarshalEmployee2json").to("log:?level=INFO&showBody=true")
//		.unmarshal().xmljson()
				.unmarshal(xmlJsonDataFormat).to("log:?level=INFO&showBody=true");

	}

}
