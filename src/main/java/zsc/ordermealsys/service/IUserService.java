package zsc.ordermealsys.service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;

public interface IUserService {
	
	ServerResponse<User> login(String username,String password);
	
	ServerResponse<String> register(User user);
	
	ServerResponse<String> checkValid(String str,String type);
	
	ServerResponse selectQuestion(String username);
	
	ServerResponse<String> checkAnswer(String username,String question, String answer);
	
	ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);
}
