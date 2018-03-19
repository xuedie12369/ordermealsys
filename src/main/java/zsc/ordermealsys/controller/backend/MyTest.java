package zsc.ordermealsys.controller.backend;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.pojo.User;

public class MyTest {

	/**
	 * @param args
	 */
	@Test
	public void sysi()
	{
	// TODO Auto-generated methotd stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
			CategoryManageController c=ac.getBean(CategoryManageController.class);
			User u=new User();
			u.setRole(1);
			u.setUserName("shn");
			/*c.addCategory(u, "shn", 1);*/
	}
}
