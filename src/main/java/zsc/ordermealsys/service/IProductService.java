package zsc.ordermealsys.service;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.ProductWithBLOBs;

public interface IProductService {
	public	ServerResponse saveOrUpdate(ProductWithBLOBs product);
	public	ServerResponse delete(ProductWithBLOBs product);
	public  ServerResponse setSaleStatus(Integer productId,Integer proStatus);
	ServerResponse manageProductDetail(Integer productId);
	ServerResponse getProductList(Integer pageNum, Integer pageSize);
	ServerResponse searchProduct(@Param("name")String name,@Param("id")Integer id,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
}
