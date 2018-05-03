package zsc.ordermealsys.service;

import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;
@Service("iUserService")
public interface IUserService {
	
	ServerResponse<User> login(String username,String password);
	
	ServerResponse<String> register(User user);
	
	ServerResponse<String> checkValid(String str,String type);
	
	ServerResponse selectQuestion(String username);
	
	ServerResponse<String> checkAnswer(String username,String question, String answer);
	
	ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);
	
	ServerResponse<Integer>  checkAdminRole(User user);
	
	
	
}
