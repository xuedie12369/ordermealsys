package zsc.ordermealsys.controller.portal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.ICartService;
import zsc.ordermealsys.vo.ShoppingCartVo;

@Controller
@RequestMapping("/cart/")
public class CartController {

	@Autowired
	private ICartService iCartService;
	
	@RequestMapping("add.do")
	@ResponseBody
	public ServerResponse<ShoppingCartVo> add(HttpSession session, Integer count,Integer productId){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.add(user.getId(), productId, count);
	}
	
	
	@RequestMapping("update.do")
	@ResponseBody
	public ServerResponse<ShoppingCartVo> update(HttpSession session, Integer count,Integer productId){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.add(user.getId(), productId, count);
	}
}
