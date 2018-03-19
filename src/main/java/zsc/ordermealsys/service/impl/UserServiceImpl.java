package zsc.ordermealsys.service.impl;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.common.TokenCache;
import zsc.ordermealsys.service.IUserService;
import zsc.ordermealsys.util.MD5Util;
import zsc.ordermealsys.dao.UserMapper;
import zsc.ordermealsys.pojo.User;
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	/**
	 * 登录接口的实现方式
	 */
	public 	ServerResponse<User>  login(String username,String password) {
		// TODO Auto-generated method stub
		int resultCount=userMapper.checkUsername(username);
		if(resultCount==0){
			System.out.println("username failed");
			return ServerResponse.createByErrorMessage("用户名不存在！");
		}
		//密码登录MD5
		//String md5Password=MD5Util.MD5EncodeUtf8(password);
		
		User user=userMapper.selectLogin(username, password);
		if(user==null){
			System.out.println("pwd failed");
			return ServerResponse.createByErrorMessage("密码错误！");
		}
		
		user.setPwd(org.apache.commons.lang3.StringUtils.EMPTY);
		System.out.println("success");
		return ServerResponse.createBySuccessMessage("登录成功！",user);
		
	}
	

	/**
	 * 注册接口的实现方式
	 */
	public ServerResponse<String> register(User user){

		int resultCount=userMapper.checkUsername(user.getUserName());
		/*if(resultCount>0){
			System.out.print("fail!more username");
			return ServerResponse.createByErrorMessage("用户名已存在");
		}*/
		ServerResponse validResponse=this.checkValid(user.getUserName(), Const.USERNAME);
		if(!validResponse.isSuccess()){
			return validResponse;
		}
		validResponse=this.checkValid(user.getEmail(), Const.EMAIL);
		if(!validResponse.isSuccess()){
			return validResponse;
		}
		/*resultCount=userMapper.checkEmail(user.getEmail());
		/*if(resultCount>0){
			System.out.print("fail!more email");
			return ServerResponse.createByErrorMessage("email已存在");
		}*/
		/*user.setType(Const.Role.ROLE_CUSTOMER);
		//MD5加密
		user.setPwd(MD5Util.MD5EncodeUtf8(user.getPwd()));*/
		
		resultCount=userMapper.insert(user);
		System.out.print("success");
		if(resultCount==0){
			return ServerResponse.createByErrorMessage("注册失败！");
		}
		return ServerResponse.createBySuccessMessage("注册成功！");
	}
	
	
	/**
	 * 校验信息接口实现方式
	 */
	public ServerResponse<String> checkValid(String str,String type){
		if(org.apache.commons.lang3.StringUtils.isNotBlank(type)){
			//开始校验
			if(Const.USERNAME.equals(type)){
				int resultCount=userMapper.checkUsername(str);
				if(resultCount>0){
					return ServerResponse.createByErrorMessage("用户名不存在！");
				}
			}
			if(Const.EMAIL.equals(type)){
				int resultCount=userMapper.checkEmail(str);
				if(resultCount>0){
					return ServerResponse.createByErrorMessage("Email已存在！");
				}
			}
		}else{
			return ServerResponse.createByErrorMessage("参数错误！");
		}
		return ServerResponse.createBySuccessMessage("校验成功！");
	}
	
	/**
	 * 查询用户安全问题接口实现方式
	 * 
	 */
	public ServerResponse selectQuestion(String username){
		ServerResponse validResponse=this.checkValid(username, Const.USERNAME);
		if(validResponse.isSuccess()){
			//用户不存在
			return ServerResponse.createByErrorMessage("用户不存在！");
		}
		String question=userMapper.selectQuestionByUsername(username);
		if(org.apache.commons.lang3.StringUtils.isNotBlank(question)){
			return ServerResponse.createBySuccessMessage(question);
		}
		return ServerResponse.createByErrorMessage("找回密码的问题是空的！");
	}
	
	/**
	 * 验证用户安全问题接口的实现方式
	 */
	public ServerResponse<String> checkAnswer(String username,String question, String answer){
		int resultCount=userMapper.checkAnswer(username, question, answer);
		if(resultCount>0){
			//说明问题及问题答案是这个用户的，并且是正确的
			String forgetToken=UUID.randomUUID().toString();
			TokenCache.setKey(TokenCache.TOKEN_PREFIX+username,forgetToken);
			return ServerResponse.createBySuccessMessage(forgetToken);
		}
		return ServerResponse.createByErrorMessage("问题的答案错误！");
	}
	
	/**
	 * 忘记密码，重置密码用户接口的实现方式
	 */
	public ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken){
		if(StringUtils.isBlank(forgetToken)){
			return ServerResponse.createByErrorMessage("参数错误，token需要传递！");
		}
		ServerResponse validResponse=this.checkValid(username, Const.USERNAME);
		if(validResponse.isSuccess()){
			//用户不存在
			return ServerResponse.createByErrorMessage("用户不存在！");
		}
		
		String token=TokenCache.getKey(TokenCache.TOKEN_PREFIX+username);
		
		if(StringUtils.isBlank(token)){
			return ServerResponse.createByErrorMessage("token无效或者过期！");
		}
		if(StringUtils.equals(forgetToken, token)){
			String md5Password=MD5Util.MD5EncodeUtf8(passwordNew);
			int rowCount=userMapper.updatePasswordByUsername(username, md5Password);
			if(rowCount>0){
				return ServerResponse.createBySuccessMessage("修改密码成功！");
			}
		}else{
			return ServerResponse.createByErrorMessage("token错误，请重新获取重置密码的token！");
		}
		return ServerResponse.createByErrorMessage("修改密码失败！");
	}

	@Override
	public ServerResponse<Integer> checkAdminRole(User user) {
		// TODO Auto-generated method stub
		if(user!=null&&user.getRole().intValue()==Const.Role.ROLE_ADMIN)
		{
			return ServerResponse.createBySuccess();
		}
		
		
		return null;
	}
}
