package com.elm.demo.bo;

import java.util.List;

import com.elm.demo.exception.ElmException;
import com.elm.demo.model.Order;
import com.elm.demo.vo.OrderVO;

public interface IOrderBO {
	
	List<Order> findOrders();
	Order findOrder(Long orderId);
	Order createOrder(OrderVO vo) throws ElmException;
}
