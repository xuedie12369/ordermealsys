package zsc.ordermealsys.controller.portal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.IOrderService;

@Controller
@RequestMapping("/order/")
public class OrderController {
	 @Autowired
	    private IOrderService iOrderService;

	//邵海楠部分
	  @RequestMapping("pay.do")
	    @ResponseBody
	    public ServerResponse pay(HttpSession session, Long orderId, HttpServletRequest request){
	        User user = (User)session.getAttribute(Const.CURRENT_USER);
	        if(user ==null){
	            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
	        }
	        String path = request.getSession().getServletContext().getRealPath("upload");
	        return iOrderService.pay(orderId,user.getId(),path);
	    }

	
}
