package com.elm.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elm.demo.bo.IOrderBO;
import com.elm.demo.exception.ElmException;
import com.elm.demo.model.Order;
import com.elm.demo.vo.OrderVO;

@RestController
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired IOrderBO bo;
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findOrders() 
	{
		List<Order> orders = bo.findOrders();
		
		if (orders == null || orders.isEmpty())
			return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> findOrder(@PathVariable("id") Long id) 
	{
		Order order = bo.findOrder(id);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public ResponseEntity<Order> createOrder(@RequestBody OrderVO orderVO) {
		logger.debug("create() ... order data is captured to object {}", orderVO);
		Order orderSaved = null;
		try {
			orderSaved = bo.createOrder(orderVO);
		} catch (ElmException e) {
			return new ResponseEntity<Order>(orderSaved, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Order>(orderSaved, HttpStatus.CREATED);
	}

}
