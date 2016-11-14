package com.elm.demo.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.elm.demo.bo.IProductBO;
import com.elm.demo.common.ConfigMgr;
import com.elm.demo.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:dao-context.xml"})
public class TestProductBO {
	
	@Autowired IProductBO bo;
	
	@Test
	public void runAll()
	{
		findProducts();
		findProductsByCategory(ConfigMgr.PRODUCT_CATEGORY.book.name());
		findProduct(1L);
	}
	
	private void findProducts() {
		String methodName = "findProducts";
		print(String.format("> %s", methodName));
				
		List<Product> list = bo.findProducts();
		Assert.assertTrue(String.format("%s: list is null or empty", methodName), list != null && !list.isEmpty());
		
		print(String.format("%s: found %d records", methodName, list.size()));
		printList(list);
		print(String.format("< %s", methodName));
	}
	
	private void findProductsByCategory(String category) {
		String methodName = String.format("findProductsByCategory(%s)", category);
		print(String.format("> %s", methodName));
				
		List<Product> list = bo.findProductsByCategory(category);
		Assert.assertTrue(String.format("%s: list is null or empty", methodName), list != null && !list.isEmpty());
		
		print(String.format("%s: found %d records", methodName, list.size()));
		printList(list);
		print(String.format("< %s", methodName));
	}
	
	private void findProduct(long productId) {
		String methodName = String.format("findProduct(%d)", productId);
		print(String.format("> %s", methodName));
		
		Product o = bo.findProduct(productId); 
		Assert.assertNotNull(String.format("%s product with id %d is found", methodName, productId), o);
		
		print(o);
		print(String.format("< %s", methodName));
	}
	
	
	protected static void print(Object obj) { System.out.println(obj); }	
	protected static void print(String msg) { System.out.println(msg); }
	
	protected static void printList(List lst) { 
		for (Object o : lst) 
			print(o);		 
	}
	
	
}
