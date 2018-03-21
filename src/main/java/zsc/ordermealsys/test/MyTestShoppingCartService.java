package zsc.ordermealsys.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zsc.ordermealsys.dao.ShoppingCartMapper;
import zsc.ordermealsys.dao.UserMapper;
import zsc.ordermealsys.service.impl.CartServiceImpl;
import zsc.ordermealsys.service.impl.UserServiceImpl;


public class MyTestShoppingCartService {
	@Resource
	ShoppingCartMapper cartMapper;
	public ShoppingCartMapper getShoppingMapperDao(){
		return cartMapper;
	}	
	public void ShoppingMapperDao(ShoppingCartMapper cartMapper) {
		this.cartMapper = cartMapper;
	} 
	
	@Test
	public void main(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		CartServiceImpl iCartService=ac.getBean(CartServiceImpl.class);
		iCartService.add(1, 1, 5);
	}
}
