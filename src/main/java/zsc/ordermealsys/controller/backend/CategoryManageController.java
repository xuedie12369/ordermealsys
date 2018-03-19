package zsc.ordermealsys.controller.backend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.ICategoryService;
import zsc.ordermealsys.service.IUserService;

@Controller
@RequestMapping("/manage/category" )
public class CategoryManageController {
  @Autowired
	 IUserService iUserService;
  @Autowired
  ICategoryService iCategoryService; 
	public ServerResponse addCategory(HttpSession session,String categoryName,@RequestParam(value = "parentId",defaultValue = "0") int parentId){
			User  user=(User) session.getAttribute(Const.CURRENT_USER);
			if(user==null)
			{
				return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");
			}
			//校验是否是管理员
			if(iUserService.checkAdminRole(user).isSuccess())
			{
				/*添加增加分类的逻辑*/
				 return iCategoryService.addCategory("分类名称", 1);
			}
			else
			{
				return ServerResponse.createByErrorMessage("无操作权限，需管理员权限");
			}
	}
}
