package com.elm.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elm.demo.bo.IProductBO;
import com.elm.demo.model.Product;

@RestController
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired IProductBO bo;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findProducts() 
	{
		List<Product> products = bo.findProducts();
		
		if (products == null || products.isEmpty())
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/category/{category}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findProductsByCategory(@PathVariable("category") String category) 
	{
		List<Product> products = bo.findProductsByCategory(category);
		
		if (products == null || products.isEmpty())
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/products/id/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Product> findProductById(@PathVariable("productId") Long productId) 
	{
		Product product = bo.findProduct(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

}
