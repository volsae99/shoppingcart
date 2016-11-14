package com.elm.demo.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elm.demo.dao.ProductDao;
import com.elm.demo.model.Product;
import com.google.common.collect.Lists;

@Service
@Repository
@Transactional(readOnly=true)
public class ProductBO implements IProductBO {
	
	Logger logger = LoggerFactory.getLogger(ProductBO.class);
	
	@Autowired private ProductDao dao;

	public List<Product> findProducts() {
		List<Product> lst = Lists.newArrayList(dao.findAll());  
		logger.debug("{} products found.", lst != null ? lst.size() : 0);		
		return lst;
	}

	public List<Product> findProductsByCategory(String category) {
		List<Product> lst = Lists.newArrayList(dao.findByCategory(category));  
		logger.debug("{} products found.", lst != null ? lst.size() : 0);		
		return lst;
	}

	public Product findProduct(Long productId) {
		Product o = dao.findOne(productId); 		
		logger.debug("Found product with id {} {}", productId, o);		
		return o;
	}

}
