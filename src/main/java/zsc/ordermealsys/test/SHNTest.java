package zsc.ordermealsys.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zsc.ordermealsys.pojo.ProductWithBLOBs;
import zsc.ordermealsys.service.IProductService;
import zsc.ordermealsys.service.impl.OrderServiceImpl;
import zsc.ordermealsys.service.impl.ProductServiceImpl;
import zsc.ordermealsys.service.impl.UserServiceImpl;

public class SHNTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
				ProductServiceImpl iProductService= ac.getBean(ProductServiceImpl.class);
//		iProductService.getProductDetail(1);
//	iProductService.getProductByKeywordCategory("7", null, 1, 10, null);


	}

}
