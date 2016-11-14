package com.elm.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name="ORDER_DETAIL")
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = -8068288720060285761L;
	
	private Long id;
	private Long orderId;
	private String name;
	private Double price;
	private Integer quantity;
	
	@Id
	@SequenceGenerator(name="ORDER_DETAIL_ID_GENERATOR", sequenceName="ORDER_DETAIL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_DETAIL_ID_GENERATOR")
	@Column(updatable=false)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name="ORDER_ID")
	public Long getOrderId() { return orderId; }
	public void setOrderId(Long orderId) { this.orderId = orderId; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public Double getPrice() { return price; }
	public void setPrice(Double price) { this.price = price; }
	
	public Integer getQuantity() { return quantity; }
	public void setQuantity(Integer quantity) { this.quantity = quantity; }
	
	public String toString() { return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE); }
	
	

}
