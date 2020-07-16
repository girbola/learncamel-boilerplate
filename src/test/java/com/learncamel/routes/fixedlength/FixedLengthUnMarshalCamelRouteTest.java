package com.learncamel.routes.fixedlength;

import java.time.LocalDate;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.EmployeeWithFixedLength;

public class FixedLengthUnMarshalCamelRouteTest extends CamelTestSupport{

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new FixedLengthUnMarshalCamelRoute();
	}

	@Test
	public void UnMarshalFixedLengthFile() {
		
		Exchange exchange = consumer.receive("direct:output");
		
		List<EmployeeWithFixedLength> employeeWithFixedLengthList = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
		
		assertNotNull(employeeWithFixedLengthList);
		
		assertEquals("dilip", employeeWithFixedLengthList.get(0).getFirstName());
		assertEquals("kevin", employeeWithFixedLengthList.get(1).getFirstName());
		
		LocalDate expetedDate1 = LocalDate.of(2017, 01, 12);
		LocalDate expetedDate2 = LocalDate.of(2018, 01, 12);
		assertEquals(expetedDate1.getYear(), employeeWithFixedLengthList.get(0).getJoiningDate());
		assertEquals(expetedDate2.getYear(), employeeWithFixedLengthList.get(1).getJoiningDate());
		
		
	}
}
