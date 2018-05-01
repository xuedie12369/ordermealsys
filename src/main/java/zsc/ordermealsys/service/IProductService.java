package zsc.ordermealsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.ProductWithBLOBs;
import zsc.ordermealsys.vo.ProductDetailVo;

public interface IProductService {
	public	ServerResponse saveOrUpdate(ProductWithBLOBs product);
	public	ServerResponse delete(Integer productId);
	public  ServerResponse setSaleStatus(Integer productId,Integer proStatus);
	ServerResponse manageProductDetail(Integer productId);
	ServerResponse getProductList(Integer pageNum, Integer pageSize);
	ServerResponse searchProduct(@Param("name")String name,@Param("id")Integer id,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
	ServerResponse<ProductDetailVo> getProductDetail(Integer productId);
	ServerResponse<PageInfo> getProductByKeywordCategory(String keyword,Integer categoryId,int pageNum,int pageSize,String orderBy);
	ServerResponse<List<ProductWithBLOBs>> listAll();
	ServerResponse<ProductDetailVo> searchProductById(Integer productId);

}

