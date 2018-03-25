package zsc.ordermealsys.controller.portal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.Address;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.IShippingService;

@Controller
@RequestMapping("/shipping/")
public class ShippingController {
	
	@Autowired
	private IShippingService iShippingService;
	
	//Spring MVC 中的特殊的绑定方式，直接绑定对象
	@RequestMapping("add.do")
	@ResponseBody
	public ServerResponse add(HttpSession session,Address address){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iShippingService.add(user.getId(),address);
	}
	
	@RequestMapping("del.do")
	@ResponseBody
	public ServerResponse del(HttpSession session,){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iShippingService.add(user.getId(),address);
	}
}
