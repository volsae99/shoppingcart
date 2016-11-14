package com.elm.demo.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.elm.demo.bo.IOrderBO;
import com.elm.demo.bo.IOrderDetailBO;
import com.elm.demo.bo.IProductBO;
import com.elm.demo.exception.ElmException;
import com.elm.demo.model.Order;
import com.elm.demo.model.OrderDetail;
import com.elm.demo.model.Product;
import com.elm.demo.vo.OrderDetailVO;
import com.elm.demo.vo.OrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:dao-context.xml"})
public class TestOrderBO {
	
	@Autowired IOrderBO bo;
	@Autowired IProductBO productBO;
	@Autowired IOrderDetailBO orderDetailBO;
	
	@Test
	public void runAll() throws ElmException
	{
		findOrders();
		findOrder(1L);
		createOrder();
		findOrders();
	}
	
	private void findOrders() {
		String methodName = "findOrders";
		print(String.format("> %s", methodName));
				
		List<Order> list = bo.findOrders();
		Assert.assertTrue(String.format("%s: list is null or empty", methodName), list != null && !list.isEmpty());
		
		print(String.format("%s: found %d records", methodName, list.size()));
		printList(list);
		print(String.format("< %s", methodName));
	}
	
	private void findOrder(long id) {
		String methodName = String.format("findOrder(%d)", id);
		print(String.format("> %s", methodName));
		
		Order o = bo.findOrder(id); 
		Assert.assertNotNull(String.format("%s order with id %d is found", methodName, id), o);
		
		print(o);
		print(String.format("< %s", methodName));
	}
	
	private void createOrder() throws ElmException {
		String methodName = "createOrder():";
		print(String.format("> %s", methodName));
		
		// order
		OrderVO orderVO = new OrderVO();
		orderVO.setCity("city");
		orderVO.setCountry("country");
		orderVO.setName("name");
		orderVO.setState("state");
		orderVO.setStreet("street");
		orderVO.setZip("zip");
		
		// products
		Product p = productBO.findProduct(1L); // find product
		List<OrderDetailVO> products = new ArrayList<OrderDetailVO>();		
		OrderDetailVO product = new OrderDetailVO();			
		product.setName(p.getName());	
		product.setPrice(p.getPrice());
		product.setCount(2);
		products.add(product); // add product to list
		
		orderVO.setProducts(products); // set list of products to order object
		
		Order orderSaved = bo.createOrder(orderVO); 
		Assert.assertNotNull(String.format("%s: failed to create order", methodName), bo.findOrder(orderSaved.getId()));
		
		print(String.format("%s order is created %s", methodName, orderSaved));
		
		print(String.format("< %s", methodName));		
	}
	
	protected static void print(Object obj) { System.out.println(obj); }	
	protected static void print(String msg) { System.out.println(msg); }
	
	protected static void printList(List lst) { 
		for (Object o : lst) 
			print(o);		 
	}
	
	
}
