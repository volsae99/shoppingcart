package com.elm.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elm.demo.model.Product;

public interface ProductDao extends CrudRepository<Product, Long> {

	List<Product> findByCategory(String category);

}
