package zsc.ordermealsys.controller.backend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.ProductWithBLOBs;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.IProductService;
import zsc.ordermealsys.service.IUserService;

@Controller
@RequestMapping("/manage/product")
public class ProductManageController {
	@Autowired
	private IUserService iUserService;
	@Autowired
	IProductService iProductService;
	@RequestMapping("saveOrUpdate")
	@ResponseBody
	public ServerResponse productSaveOrUpdate(HttpSession session,ProductWithBLOBs product)
	{
	   User user=(User) session.getAttribute(Const.CURRENT_USER);
	   if(user==null)
	   {
		   return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
	   }
	   if(iUserService.checkAdminRole(user).isSuccess())
	   {
		   return iProductService.saveOrUpdate(product);
	   }
		return ServerResponse.createByErrorMessage("无权限操作");
	}
    @RequestMapping("set_sale_proStatus.do")
	@ResponseBody
	public ServerResponse setSaleproStatus(HttpSession session,Integer productId,Integer proStatus)
	{
	   User user=(User) session.getAttribute(Const.CURRENT_USER);
	   if(user==null)
	   {
		   return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
	   }
	   if(iUserService.checkAdminRole(user).isSuccess())
	   {
		    return iProductService.setSaleStatus(productId, proStatus);
	   }
		return ServerResponse.createByErrorMessage("无权限操作");
	}

}
