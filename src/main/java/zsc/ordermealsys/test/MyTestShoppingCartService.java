package zsc.ordermealsys.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zsc.ordermealsys.dao.ShoppingCartMapper;
import zsc.ordermealsys.service.impl.CartServiceImpl;


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
		/*iCartService.add(1, 1, 5);
		iCartService.list(1);
		iCartService.update(1, 1, 5);*/
		iCartService.deleteProduct(1, "1");
	}
}
