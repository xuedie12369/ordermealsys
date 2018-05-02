package zsc.ordermealsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.CategoryMapper;
import zsc.ordermealsys.dao.UserMapper;
import zsc.ordermealsys.pojo.Category;
import zsc.ordermealsys.pojo.User;

@Service("adminServiceImpl")
public class AdminServiceImpl {
	@Autowired
	private UserMapper userMapper;
	private CategoryMapper categoryMapper; 
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public CategoryMapper getCategoryMapper() {
		return categoryMapper;
	}

	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}
	
	
	//查询用户
	public ServerResponse<User> queryuser(String username){
		int resultCount=userMapper.checkUsername(username);
		User user=userMapper.selectByUserName(username);
		if(resultCount==0){
			return ServerResponse.createByErrorMessage("您想要查找的用户不存在！");
		}else{
			return ServerResponse.createBySuccess("查找成功！", user);
		}
	}
	
	//冻结用户
	public ServerResponse<String> freezeUser(String username){
		int resultCount=userMapper.checkUsername(username);
		User user=userMapper.selectByUserName(username);
		if(resultCount==0){
			return ServerResponse.createByErrorMessage("您所查询的用户不存在！");
		}else{
			user.setStatus(0);
			userMapper.updateByPrimaryKeySelective(user);
			return ServerResponse.createBySuccessMessage("已成功冻结您所指定的用户！");
		}
	}
	
	//添加分类
	public ServerResponse<String> addCategory(Category category){
		categoryMapper.insert(category);
		return ServerResponse.createBySuccessMessage("添加商品分类成功！");
	}
	
	//修改分类
	public ServerResponse<Category> updateCategoryByCategoryId(int categoryId, String categoryName){
		Category category=categoryMapper.selectByPrimaryKey(categoryId);
		if(category==null){
			return ServerResponse.createByErrorMessage("您所查询的分类不存在！");
		}else{
			category.setName(categoryName);
			categoryMapper.updateByPrimaryKey(category);
			return ServerResponse.createBySuccessMessage("修改成功！");
		}
	}
	
	//查询分类
	public ServerResponse<Category> searchCategory(int categoryId){
		Category category=categoryMapper.selectByPrimaryKey(categoryId);
		if(category==null){
			return ServerResponse.createByErrorMessage("您所查询的分类不存在！");
		}else{
			return ServerResponse.createBySuccess("查询成功！", category);
		}
	}

	//删除分类
	public ServerResponse<String> deleteCategory(int categoryId){
		Category category=categoryMapper.selectByPrimaryKey(categoryId);
		if(category==null){
			return ServerResponse.createByErrorMessage("您所查询的分类不存在！");
		}else{
			categoryMapper.deleteByPrimaryKey(categoryId);
			return ServerResponse.createBySuccessMessage("删除成功！");
		}
	}
	
	
}
