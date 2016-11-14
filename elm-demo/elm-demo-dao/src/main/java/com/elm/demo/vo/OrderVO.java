package com.elm.demo.vo;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OrderVO {

	private Long id;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	private List<OrderDetailVO> products;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public List<OrderDetailVO> getProducts() {
		return products;
	}
	public void setProducts(List<OrderDetailVO> products) {
		this.products = products;
	}
	public String toString() { return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE); }

}
