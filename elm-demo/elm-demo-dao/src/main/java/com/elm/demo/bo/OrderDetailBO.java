package com.elm.demo.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elm.demo.dao.OrderDetailDao;
import com.elm.demo.exception.ElmException;
import com.elm.demo.model.OrderDetail;
import com.elm.demo.vo.OrderDetailVO;
import com.google.common.collect.Lists;

@Service
@Repository
@Transactional(readOnly=true)
public class OrderDetailBO implements IOrderDetailBO {
	
	Logger logger = LoggerFactory.getLogger(OrderDetailBO.class);
	
	@Autowired private OrderDetailDao dao;

	public List<OrderDetail> findOrderDetails() {
		List<OrderDetail> lst = Lists.newArrayList(dao.findAll());  
		logger.debug("{} order details found.", lst != null ? lst.size() : 0);		
		return lst;
	}

	public OrderDetail findOrderDetail(Long id) {
		OrderDetail o = dao.findOne(id); 		
		logger.debug("Found order deatil with id {} {}", id, o);		
		return o;
	}

	@Transactional(readOnly=false)
	public OrderDetail createOrderDetail(OrderDetailVO vo, Long orderId) throws ElmException {
		OrderDetail o = new OrderDetail();
		o.setOrderId(orderId); // FK to Order table
		o.setName(vo.getName());
		o.setPrice(vo.getPrice());
		o.setQuantity(vo.getCount());
		OrderDetail oSaved = null;
		try 
		{
			logger.debug("Saving order detail ... {}", o);
			oSaved = dao.save(o); // save order detail
			logger.debug("Order detail is saved {}", oSaved);
		} catch (Throwable t) {
			logger.error("Order detail is not saved.  Exit with error {}", t.getMessage(), t);
			throw new ElmException("Order detail is not saved. Exit with error.", t);
		}
		return oSaved;
		
	}

}
