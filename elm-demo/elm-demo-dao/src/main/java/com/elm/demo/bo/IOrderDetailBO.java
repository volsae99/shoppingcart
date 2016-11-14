package com.elm.demo.bo;

import java.util.List;

import com.elm.demo.exception.ElmException;
import com.elm.demo.model.OrderDetail;
import com.elm.demo.vo.OrderDetailVO;

public interface IOrderDetailBO {
	
	List<OrderDetail> findOrderDetails();
	OrderDetail findOrderDetail(Long id);
	OrderDetail createOrderDetail(OrderDetailVO vo, Long orderId) throws ElmException;
}
