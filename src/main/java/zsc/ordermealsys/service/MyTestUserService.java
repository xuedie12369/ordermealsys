package zsc.ordermealsys.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.UserMapper;
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
		MyTestUserService u= ac.getBean(MyTestUserService.class);
		/*User us=new User();
		us.setUserName("dm");
		us.setEmail("007");*/
		int n=u.userDao.checkUsername("shn");
		//u.register(us);t
		System.out.print(n);
	}
}
