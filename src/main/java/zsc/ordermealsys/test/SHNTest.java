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
<<<<<<< HEAD
				ProductServiceImpl iProductService= ac.getBean(ProductServiceImpl.class);
//		iProductService.getProductDetail(1);
	iProductService.getProductByKeywordCategory("7", null, 1, 10, null);
=======
		IProductService iProductService= ac.getBean(IProductService.class);
		iProductService.getProductDetail(1);
		
>>>>>>> parent of 0550011... 增加了前端搜索产品的功能（功能不完善，有待改进）
		ProductWithBLOBs s=new ProductWithBLOBs();
	}

}
