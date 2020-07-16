package com.learncamel.routes.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.Employee2;

public class CsvMarshalRouteTest extends CamelTestSupport{

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		
		return new CSVMarshalRoute();
	}
	
	@Test
	public void csvMarshalRouteTest() {
		
		Employee2 employee = new Employee2();
		employee.setId("1");
		employee.setLastName("Sundar");
		employee.setFirstName("Dilip");
		

		Employee2 employee1 = new Employee2();
		employee1.setId("2");
		employee1.setLastName("Lokka");
		employee1.setFirstName("Marko");
			
		List<Employee2> employeeList = new ArrayList<>();
		employeeList.add(employee);
		employeeList.add(employee1);
		
		template.sendBody("direct:objInput", employeeList);
	
		File file = new File("data/csv/output");
		assertTrue(file.isDirectory());
	}

}
