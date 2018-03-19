package zsc.ordermealsys.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
		if (parentId == null || categoryName.isEmpty()) {
			return ServerResponse.createByErrorMessage("添加品类参数错误");
		}
		Category category = new Category();
		category.setName(categoryName);
		category.setParentId(parentId);
		int rowCount = categoryMapper.insert(category);
		if (rowCount > 0) {
			System.out.print(rowCount);
			return ServerResponse.createBySuccessMessage("添加分类成功");
		} else {
			return ServerResponse.createByErrorMessage("添加分类失败");
		}

	}

	@Override
	public ServerResponse updateCategoryName(Integer parentId, String categoryName) {
		// TODO Auto-generated method stub
		if (parentId == null || categoryName.isEmpty()) {
			return ServerResponse.createByErrorMessage("添加品类参数错误");
		}
		Category category = new Category();
		category.setId(2);
		category.setName(categoryName);
		category.setParentId(parentId);
		int rowCount = categoryMapper.updateByPrimaryKeySelective(category);
		System.out.print("受影响的行数" + rowCount);
		if (rowCount > 0) {
			return ServerResponse.createBySuccess();
		}
		return ServerResponse.createByErrorMessage("更新分类名称失败");
	}


	@Override
	public ServerResponse<List<Category>> selectCategoryChildrenByParentId( Integer parentId) {
		// TODO Auto-generated method stub
		List<Category> listCategory=categoryMapper.selectCategoryChildrenByParentId(parentId);
		if(listCategory.isEmpty())
		{
			System.out.print("未查询到子节点");
		}
		return ServerResponse.createBySuccessMessage(listCategory);
	}

	@Override
	public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer parentId) {
		// TODO Auto-generated method stub
		return null;
	}



}
