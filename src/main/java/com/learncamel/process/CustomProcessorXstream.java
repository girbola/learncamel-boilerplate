package com.learncamel.process;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.learncamel.domain.Employee;

public class CustomProcessorXstream implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String newBody = exchange.getIn().getBody(String.class);
		StringTokenizer tokenizer = new StringTokenizer(newBody, ",");
		
		Employee employee = new Employee();
				while(tokenizer.hasMoreElements()) {
					employee.setId((String)tokenizer.nextElement());
					employee.setName((String)tokenizer.nextElement());
					employee.setJoinDate((String)tokenizer.nextElement());
				}
				exchange.getIn().setBody(employee);
	}


}
