package zsc.ordermealsys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.Category;
/*@Service("iCategoryService")*/
public interface ICategoryService {
	
    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(Integer categoryId,String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);


}
