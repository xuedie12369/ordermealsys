package zsc.ordermealsys.controller.backend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.ICategoryService;
import zsc.ordermealsys.service.IUserService;
import zsc.ordermealsys.service.impl.CategoryServiceImpl;

@Controller()
@RequestMapping("/manage/category")
public class CategoryManageController {
	@Autowired
	IUserService iUserService;
	@Autowired
	ICategoryService iCategoryService;

	/*
		*//**
			 * 添加分类 作者：邵海楠
			 * 
			 * @param session
			 * @param categoryName
			 * @param parent_id
			 * @return
			 */
	@RequestMapping("add_category.do")
	@ResponseBody
	public ServerResponse addCategory(HttpSession session, String categoryName,
			@RequestParam(value = "parent_id", defaultValue = "0") int parent_id) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");
		}
		// 校验是否是管理员
		if (iUserService.checkAdminRole(user).isSuccess()) {
			// 添加增加分类的逻辑
			return iCategoryService.addCategory("分类名称", 1);
		} else {
			return ServerResponse.createByErrorMessage("无操作权限，需管理员权限");
		}
	}

	/**
	 * 更新分类名称 作者：邵海楠
	 * 
	 * @param session
	 * @param categoryName
	 * @param parent_id
	 * @return
	 */
	@RequestMapping("set_category_name.do")
	@ResponseBody
	public ServerResponse updateCategory(HttpSession session, String categoryName, int parent_id) {
		 User user=(User) session.getAttribute(Const.CURRENT_USER); 
		/*User user = session;*/
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");
		}

		if (iUserService.checkAdminRole(user).isSuccess()) {
			return iCategoryService.updateCategoryName(parent_id, categoryName);
		} else {
			return ServerResponse.createByErrorMessage("无操作权限，需管理员权限");
		}

	}

	/**
	 * 通过父节点查询同级的节点 作者：邵海楠
	 * 
	 * @param parent_id
	 * @return
	 */
	 @RequestMapping("get_category.do")
	 @ResponseBody
	public ServerResponse selectCategoryChildrenByParentId(int parent_id) {

		return iCategoryService.selectCategoryChildrenByParentId(parent_id);
	}

}
