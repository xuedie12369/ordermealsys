package zsc.ordermealsys.controller.backend;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.dao.CategoryMapper;
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
			/*CategoryManageController c=new CategoryManageController();*/
			User u=new User();
 			u.setRole(1);
 			u.setId(2);
			u.setUserName("shn");
			/*c.selectCategoryChildrenByParentId(u, 2);*/
		/*	c.updateCategory(u, "3", 3);*/
		/* CategoryMapper cc=	ac.getBean(CategoryMapper.class);*/
		/*	System.out.print(cc.selectOne(3));*/
	}
}
