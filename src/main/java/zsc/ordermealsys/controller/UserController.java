package zsc.ordermealsys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.IUserService;

@Controller
@RequestMapping("user/")
public class UserController {
	@Autowired
	private IUserService iUserService;
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<User> login(String username,String password,HttpSession session){
		ServerResponse<User> response=iUserService.login(username, password);
		System.out.print("用户名是:"+username);
		if(response.isSuccess()){
			System.out.print("执行了登录方法");
			session.setAttribute(Const.CURRENT_USER,response.getData());
		}
		return  response;
	}
	
	/**
	 * 用户登录退出
	 * @param session
	 * @return
	 */
	@RequestMapping(value="logout.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<String> logout(HttpSession session){
		session.removeAttribute(Const.CURRENT_USER);
		return ServerResponse.createBySuccess();
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value="register.do",method=RequestMethod.POST)
	@ResponseBody
	public ServerResponse<String> register(User user){
		System.out.print(user.getEmail()+"这是邮箱");
		return iUserService.register(user);
	}
	
	/**
	 * 用户注册校验
	 * @param str
	 * @param type
	 * @return
	 */
	@RequestMapping(value="check_valid.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<String> checkValid(String str,String type){
		return iUserService.checkValid(str, type);
	}
	
	/**
	 * 获取用户信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value="get_user_info.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<User> getUserInfo(HttpSession session){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user!=null){
			return ServerResponse.createBySuccess(user);
		}
		return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户的信息！");
	}
	
	/**
	 * 获取密保问题
	 * @param username
	 * @return
	 */
	@RequestMapping(value="forget_get_question.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<String> forgetGetQuestion(String username){
		return iUserService.selectQuestion(username);
	}
	
	/**
	 * 检查密保答案
	 * @param username
	 * @param question
	 * @param answer
	 * @return
	 */
	@RequestMapping(value="forget_check_answer.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<String> forgetCheckAnswer(String username,String question,String answer){
		return iUserService.checkAnswer(username, question, answer);
	}
	
	/**
	 * 重置用户密码
	 * @param username
	 * @param passwordNew
	 * @param forgetToken
	 * @return
	 */
	@RequestMapping(value="forget_reset_password.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken){
		return iUserService.forgetResetPassword(username, passwordNew, forgetToken);
	}
}
