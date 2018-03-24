package zsc.ordermealsys.controller.portal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;

@Controller
@RequestMapping("/order/")
public class OrderController {
	 
	public ServerResponse pay(HttpSession session,Long orderID,User user_ID)
	{
		return null;
	}
	
}
