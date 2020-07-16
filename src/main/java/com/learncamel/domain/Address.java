package com.learncamel.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", skipFirstLine = true, generateHeaderColumns = true)
public class Address {

	@Override
	public String toString() {
		return "Address [addressline=" + addressline + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", county=" + country + "]";
	}

	@DataField(pos = 4)
	private String addressline;
	@DataField(pos = 5)
	private String city;
	@DataField(pos = 6)
	private String state;
	@DataField(pos = 7)
	private String zip;
	@DataField(pos = 8)
	private String country;

	public String getAddressline() {
		return addressline;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}

	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setCountry(String county) {
		this.country = county;
	}

}
