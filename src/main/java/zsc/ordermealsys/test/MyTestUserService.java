package zsc.ordermealsys.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.controller.UserController;
import zsc.ordermealsys.dao.UserMapper;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.impl.UserServiceImpl;
/*误删*/
/*误删*/
/*误删*/
/*误删*/
/*误删*/
/*误删*/
/*误删*/
/*误删*/
/*误删*/
/*误删*/
/*误删*/
/*误删*/
@Service
public class MyTestUserService {
	@Resource
	UserMapper userDao;

	public UserMapper getUserDao() {
		return userDao;
	}

	public void setUserDao(UserMapper userDao) {
		this.userDao = userDao;
	}
	@Test
	public  void main() {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl u= ac.getBean(UserServiceImpl.class);
		/*User us=new User();
		us.setUserName("dm");
		us.setEmail("007");*/
		u.login("shn", "123");
		//u.register(us);

		/*System.out.print(userDao.checkUsername("shn"));*/
	}

}
/*=======
package zsc.ordermealsys.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.dao.ProductMapper;
import zsc.ordermealsys.dao.UserMapper;
import zsc.ordermealsys.pojo.ProductWithBLOBs;
import zsc.ordermealsys.service.impl.ProductServiceImpl;
import zsc.ordermealsys.service.impl.UserServiceImpl;
误删
误删
误删
误删
误删
误删
误删
误删
误删
误删
误删
误删
@Service
public class MyTestUserService {
	@Resource
 	UserMapper userDao;

	public UserMapper getUserDao() {
		return userDao;
	}

	public void setUserDao(UserMapper userDao) {
		this.userDao = userDao;
	}
	@Test
	public  void main() {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl u= ac.getBean(UserServiceImpl.class);
		IProductService iProductService= ac.getBean(IProductService.class);
		ProductWithBLOBs s=new ProductWithBLOBs();
		s.setName("产名称");
		iProductService.saveOrUpdate(s);
//		iProductService.setSaleStatus(2, 3);

		iProductService.manageProductDetail(1);
		User us=new User();
		us.setUserName("dm");
		us.setEmail("007");
		int count=u.getUserMapper().checkUsername("shn");
		//u.register(us);

		System.out.print(userDao.checkUsername("shn"));
	}

}
>>>>>>> origin/master:src/main/java/zsc/ordermealsys/service/MyTestUserService.java
 */