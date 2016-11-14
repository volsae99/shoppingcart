package com.elm.demo.bo;

import java.util.List;

import com.elm.demo.model.Product;

public interface IProductBO {
	
	List<Product> findProducts();
	List<Product> findProductsByCategory(String category);
	Product findProduct(Long productId);

}
