package zsc.ordermealsys.controller.backend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.IFileService;
import zsc.ordermealsys.service.IUserService;

@Controller
@RequestMapping("/manage/file")
public class FileUploadController {
	@Autowired
	IFileService iFileService;
	@Autowired
	IUserService iUserService;
@RequestMapping(value="upload.do",method=RequestMethod.POST)
@ResponseBody
	public ServerResponse upload(HttpSession session, MultipartFile file,HttpServletRequest request) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		
		System.out.print("上传的文件名称是:"+file.getOriginalFilename());
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");
		}
		// 校验是否是管理员
		if (iUserService.checkAdminRole(user).isSuccess()) {
			// 添加增加分类的逻辑
			String path = request.getSession().getServletContext().getRealPath("/productImg");
			return ServerResponse.createBySuccessMessage(iFileService.upload(file, path));
		} else {
			return ServerResponse.createByErrorMessage("无操作权限，需管理员权限");
		}
	}
}