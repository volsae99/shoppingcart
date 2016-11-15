package com.elm.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name="ORDERS")
public class Order implements Serializable {

	private static final long serialVersionUID = -3939111002311054611L;
	
	private Long id;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	private List<OrderDetail> products;
	
	@Id
	@SequenceGenerator(name="ORDER_ID_GENERATOR", sequenceName="ORDER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_ID_GENERATOR")
	@Column(updatable=false)	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getStreet() { return street; }
	public void setStreet(String street) { this.street = street; }

	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }

	public String getState() { return state; }
	public void setState(String state) { this.state = state; }

	public String getZip() { return zip; }
	public void setZip(String zip) { this.zip = zip; }

	public String getCountry() { return country; }
	public void setCountry(String country) { this.country = country; }

	@OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="ORDER_ID")
	public List<OrderDetail> getProducts() { return products; }
	public void setProducts(List<OrderDetail> products) { this.products = products; }

	public String toString() { return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE); }


}
