package zsc.ordermealsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.CategoryMapper;
import zsc.ordermealsys.pojo.Category;
import zsc.ordermealsys.service.ICategoryService;
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public ServerResponse addCategory(String categoryName, Integer parentId) {
		// TODO Auto-generated method stub
		if(parentId==null||categoryName.isEmpty())
		{
			return ServerResponse.createByErrorMessage("添加品类参数错误");
		}
		Category category=new Category();
		category.setName(categoryName);
		category.setParentId(parentId);
		int rowCount=categoryMapper.insert(category);
		if(rowCount>0)
		{
			System.out.print(rowCount);
			return  ServerResponse.createBySuccessMessage("添加分类成功");
		}
		else
		{
			return ServerResponse.createByErrorMessage("添加分类失败");
		}
		
		
	}

	@Override
	public ServerResponse updateCategoryName(Integer categoryId, String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
