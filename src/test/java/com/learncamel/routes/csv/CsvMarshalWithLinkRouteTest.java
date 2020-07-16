package com.learncamel.routes.csv;

import java.io.File;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Address;
import com.learncamel.domain.EmployeeWithAddress;

public class CsvMarshalWithLinkRouteTest extends CamelTestSupport {

	@Override
	public RoutesBuilder createRouteBuilder() throws Exception {
		return new CsvMarshalWithLinkRoute();
	}
	
	@Test
	public void marshalCsvWithLinkRoute() {
		
		EmployeeWithAddress employeeWithAddress = new EmployeeWithAddress();
		employeeWithAddress.setId("1");
		employeeWithAddress.setFirstName("marko");
		employeeWithAddress.setLastName("lokka");
		Address address = new Address();
		address.setAddressline("12345");
		address.setCity("Apple Valley");
		address.setState("Minnesota");
		address.setZip("12345");
		address.setCountry("USA");
		employeeWithAddress.setAddress(address);
		
		template.sendBody("direct:objInput", employeeWithAddress);
		
		File file = new File("data/csv/output/outputWithAddress.txt");
		
		assertTrue(file.exists());
		
		
		
	}
}
