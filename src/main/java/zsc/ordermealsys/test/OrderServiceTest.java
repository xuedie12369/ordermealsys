package zsc.ordermealsys.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zsc.ordermealsys.controller.portal.OrderController;
import zsc.ordermealsys.dao.OrderMapper;
import zsc.ordermealsys.pojo.Order;
import zsc.ordermealsys.service.impl.OrderServiceImpl;

public class OrderServiceTest {
	@Test
	public  void  ty() {
		// TODO Auto-generated method stub

	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//	OrderServiceImpl orderServiceImpl= ac.getBean(OrderServiceImpl.class);
	/*OrderMapper orderMapper=ac.getBean(OrderMapper.class);
*/
	/*Order o=orderMapper.selectByUserIdAndOrderId(11, 1L);
		System.out.print(o.getSellerName()+o.getOrderNo());
	*/
	OrderServiceImpl iOrderService=ac.getBean(OrderServiceImpl.class);
	iOrderService.pay(19L, 11, "upload");
	
	}
	
	
	
}
