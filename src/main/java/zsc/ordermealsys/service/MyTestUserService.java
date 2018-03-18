package zsc.ordermealsys.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.controller.UserController;
import zsc.ordermealsys.dao.UserMapper;
import zsc.ordermealsys.impl.UserServiceImpl;
import zsc.ordermealsys.pojo.User;
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
		u.login("shn", "1234");
		//u.register(us);
	
		/*System.out.print(userDao.checkUsername("shn"));*/
	}

}
