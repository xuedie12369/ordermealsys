package zsc.ordermealsys.service;

import org.springframework.stereotype.Service;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.Category;
import zsc.ordermealsys.pojo.User;

@Service("iAdminService")
public interface IAdminService {
	
	ServerResponse<User> queryuser(String username);
	
	ServerResponse<String> freezeUser(String username);
	
	ServerResponse<String> addCategory(Category category);
	
	ServerResponse<Category> updateCategoryByCategoryId(int categoryId, String categoryName);
	
	ServerResponse<Category> searchCategory(int categoryId);
	
	ServerResponse<String> deleteCategory(int categoryId);
	
}
