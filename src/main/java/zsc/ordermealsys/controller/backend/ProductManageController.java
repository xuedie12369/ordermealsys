package zsc.ordermealsys.controller.backend;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Maps;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.ProductWithBLOBs;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.IFileService;
import zsc.ordermealsys.service.IProductService;
import zsc.ordermealsys.service.IUserService;
import zsc.ordermealsys.util.PropertiesUtil;

@Controller
@RequestMapping("/manage/product")
public class ProductManageController {
	@Autowired
	private IUserService iUserService;
	@Autowired
	IProductService iProductService;
	@Autowired
	IFileService iFileService;
	/**
	 * 保存/更新产品 作者:邵海楠
	 */
	@RequestMapping(value="saveOrUpdate.do",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse productSaveOrUpdate(HttpSession session, ProductWithBLOBs product) {
		System.out.print("进入添加产品函数");
		System.out.print("分类的ID是:"+product.getCategoryId());
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		
		System.out.print("用户账号是:"+user.getUserName());
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
		}
		if (iUserService.checkAdminRole(user).isSuccess()) {
			return iProductService.saveOrUpdate(product);
		}
		return ServerResponse.createByErrorMessage("无权限操作");
	}

	/**
	 * 设置产品状态（即设置产品的上下架） 作者:邵海楠
	 * 
	 * @param session
	 * @param productId
	 * @param proStatus
	 * @return
	 */
	@RequestMapping("set_sale_proStatus.do")
	@ResponseBody
	public ServerResponse setSaleproStatus(HttpSession session, Integer productId, Integer proStatus) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
		}
		if (iUserService.checkAdminRole(user).isSuccess()) {
			return iProductService.setSaleStatus(productId, proStatus);
		}
		return ServerResponse.createByErrorMessage("无权限操作");
	}
	
	
	/**
	 * 设置产品状态（即设置产品的上下架） 作者:邵海楠
	 * 
	 * @param session
	 * @param productId
	 * @param proStatus
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public ServerResponse delete(HttpSession session, Integer productId) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
		}
		if (iUserService.checkAdminRole(user).isSuccess()) {
			return iProductService.delete(productId);
		}
		return ServerResponse.createByErrorMessage("无权限操作");
	}

	@RequestMapping("detail.do")
	@ResponseBody
	public ServerResponse getDetail(HttpSession session, Integer productId) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
		}
		if (iUserService.checkAdminRole(user).isSuccess()) {
			return iProductService.manageProductDetail(productId);
		}
		return ServerResponse.createByErrorMessage("无权限操作");
	}

	/**
	 * 管理员获得产品列表
	 * 
	 * @param session
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("list.do")
	@ResponseBody
	public ServerResponse getList(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		{
			User user = (User) session.getAttribute(Const.CURRENT_USER);
			if (user == null) {
				return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请先登录");
			}
			if (iUserService.checkAdminRole(user).isSuccess()) {
				return iProductService.getProductList(1, 10);
			}
			return ServerResponse.createByErrorMessage("无权限操作");
		}
	}

/**
 * 查找产品
 * 作者：邵海楠
 * @param session
 * @param productName
 * @param productId
 * @param pageNum
 * @param pageSize
 * @return
 */
	@RequestMapping("search.do")
	@ResponseBody
	public ServerResponse productSearch(HttpSession session, String productName, Integer productId,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");

		}
		if (iUserService.checkAdminRole(user).isSuccess()) {
			// 填充业务
			return iProductService.searchProduct(productName, productId, pageNum, pageSize);
		} else {
			return ServerResponse.createByErrorMessage("无权限操作");
		}
	}
	
	/**
	 * 上传图片，但是只上传到web-app下的ordermealsys下的upload目录下
	 * 没有完成，把通过转移到ftp服务器的功能
	 * @param file
	 * @param request
	 * @return
	 */
@RequestMapping("upload.do")
	public ServerResponse upload(MultipartFile file,HttpServletRequest request)
	{
		System.out.println("这里是上传文件的函数");
	   String path=request.getSession().getServletContext().getRealPath("upload");
	   String targetFileName= iFileService.upload(file, path);
	   String url=PropertiesUtil.getProperty("ftp.server.ip")+targetFileName;
		Map fileMap=Maps.newHashMap();
		fileMap.put(url, targetFileName);
		fileMap.put("uri", url);
		return ServerResponse.createBySuccess(fileMap);
	}



}
