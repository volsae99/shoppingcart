package com.elm.demo.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.elm.demo.bo.IOrderDetailBO;
import com.elm.demo.model.OrderDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:dao-context.xml"})
public class TestOrderDetailBO {
	
	@Autowired IOrderDetailBO bo;
	
	@Test
	public void runAll()
	{
		findOrderDetails();
		findOrderDetail(1L);
	}
	
	private void findOrderDetails() {
		String methodName = "findOrderDetails";
		print(String.format("> %s", methodName));
				
		List<OrderDetail> list = bo.findOrderDetails();
		Assert.assertTrue(String.format("%s: list is null or empty", methodName), list != null && !list.isEmpty());
		
		print(String.format("%s: found %d records", methodName, list.size()));
		printList(list);
		print(String.format("< %s", methodName));
	}
	
	private void findOrderDetail(long id) {
		String methodName = String.format("findOrderDetail(%d)", id);
		print(String.format("> %s", methodName));
		
		OrderDetail o = bo.findOrderDetail(id); 
		Assert.assertNotNull(String.format("%s order detail with id %d is found", methodName, id), o);
		
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
