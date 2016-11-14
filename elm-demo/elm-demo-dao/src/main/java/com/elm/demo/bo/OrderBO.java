package com.elm.demo.bo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elm.demo.dao.OrderDao;
import com.elm.demo.dao.OrderDetailDao;
import com.elm.demo.exception.ElmException;
import com.elm.demo.model.Order;
import com.elm.demo.model.OrderDetail;
import com.elm.demo.vo.OrderDetailVO;
import com.elm.demo.vo.OrderVO;
import com.google.common.collect.Lists;

@Service
@Repository
@Transactional(readOnly=true)
public class OrderBO implements IOrderBO {
	
	Logger logger = LoggerFactory.getLogger(OrderBO.class);
	
	@Autowired private OrderDao dao;
	@Autowired private IOrderDetailBO orderDetailBO;

	public List<Order> findOrders() {
		List<Order> lst = Lists.newArrayList(dao.findAll());  
		logger.debug("{} orders found.", lst != null ? lst.size() : 0);		
		return lst;
	}

	public Order findOrder(Long orderId) {
		Order o = dao.findOne(orderId); 		
		logger.debug("Found order with id {} {}", orderId, o);		
		return o;
	}

	@Transactional(readOnly=false)
	public Order createOrder(OrderVO vo) throws ElmException 
	{
		if (vo == null || vo.getProducts() == null || vo.getProducts().isEmpty()) {
			logger.debug("Order is not saved.  Not enough information.");
			return null;	
		}

		Long orderId = null; // PK for order object
		
		try {
		
		// convert order VO to model and save in database
		Order order = new Order();
		order.setCity(vo.getCity());
		order.setCountry(vo.getCountry());
		order.setName(vo.getName());
		order.setState(vo.getState());
		order.setStreet(vo.getStreet());
		order.setZip(vo.getZip());
		
		logger.debug("Saving order ... {}", order);
		Order orderSaved = dao.save(order); // persist order object
		orderId = orderSaved.getId();  // order is persisted and PK is generated
		logger.debug("Order is saved {}", orderSaved);		
		
		// loop via product VO objects from UI and persist them as order details		
		for (OrderDetailVO productVO : vo.getProducts()) {
			orderDetailBO.createOrderDetail(productVO, orderId);
		}

		} catch (Throwable e) {
			logger.error("Order is not saved.  Exit with error {}", e.getMessage(), e);
			throw new ElmException("Order is not saved. Exit with error.", e);
		}
		
		return findOrder(orderId); // this call will populate order details list on the order object
	}
	
	

}
