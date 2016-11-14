package com.elm.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.elm.demo.model.Order;

public interface OrderDao extends CrudRepository<Order, Long> {

}
