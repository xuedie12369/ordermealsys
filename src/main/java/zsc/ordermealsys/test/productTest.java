package zsc.ordermealsys.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zsc.ordermealsys.dao.ProductMapper;
import zsc.ordermealsys.service.IOrderService;
import zsc.ordermealsys.service.IProductService;

public class productTest {
@Test
	public  void sys1() {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductMapper product= ac.getBean(ProductMapper.class);
	
		System.out.print(	product.selectByPrimaryKey(1).getName());
	}
	

}
