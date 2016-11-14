package com.elm.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.elm.demo.model.OrderDetail;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Long> {

}
