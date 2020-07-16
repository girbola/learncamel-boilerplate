package com.learncamel.routes.fixedlength;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.domain.EmployeeWithFixedLength;

public class FixedLengthUnMarshalCamelRouteTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new FixedLengthUnMarshalCamelRoute();
	}

	@Test
	public void testLocalDate() {
		LocalDate ld = LocalDate.of(2017, 01, 12);

		DateTimeFormatter df = DateTimeFormatter.ofPattern("ddMMyyyy");
		System.out.println("LocalDate is : " + df.format(ld));
		
	}

	@Test
	public void UnMarshalFixedLengthFile() {

		Exchange exchange = consumer.receive("direct:output");

		List<EmployeeWithFixedLength> employeeWithFixedLengthList = (List<EmployeeWithFixedLength>) exchange.getIn()
				.getBody();

		assertNotNull(employeeWithFixedLengthList);

		assertEquals("dilip", employeeWithFixedLengthList.get(0).getName());
		assertEquals("kevin", employeeWithFixedLengthList.get(1).getName());
//
		LocalDate expetedDate1 = LocalDate.of(2017, 01, 12);
		System.out.println("expetedDate1: " + expetedDate1);
		
		LocalDate expetedDate2 = LocalDate.of(2018, 01, 12);
		assertEquals(expetedDate1.getYear(), employeeWithFixedLengthList.get(0).getJoiningDate().getYear());
		assertEquals(expetedDate2.getYear(), employeeWithFixedLengthList.get(1).getJoiningDate().getYear());

		assertEquals(30, employeeWithFixedLengthList.get(0).getAge());
		assertEquals(30, employeeWithFixedLengthList.get(1).getAge());
		BigDecimal expectedDilipSalary = new BigDecimal("80000");
		BigDecimal expectedKevinSalary = new BigDecimal("90000");
		
		assertEquals(expectedDilipSalary, employeeWithFixedLengthList.get(0).getSalery());
		assertEquals(expectedKevinSalary, employeeWithFixedLengthList.get(0).getSalery());
		
		
	}
}
