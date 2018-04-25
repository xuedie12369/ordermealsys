package zsc.ordermealsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.UserMapper;
import zsc.ordermealsys.pojo.User;

@Service("adminServiceImpl")
public class AdminServiceImpl {
	@Autowired
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public ServerResponse<String> queryuser(String username){
		int resultCount=userMapper.checkUsername(username);
		User user;
		if(resultCount==0){
			return ServerResponse.createByErrorMessage("您想要查找的用户不存在！");
		}else{
			
		}
	}
}
