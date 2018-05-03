package zsc.ordermealsys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.ShoppingCart;
import zsc.ordermealsys.vo.ShoppingCartVo;

@Service("iCartService")
public interface ICartService {
	
	ServerResponse<ShoppingCartVo> add(Integer userId,Integer productId,Integer count);
	
	ServerResponse<ShoppingCartVo> update(Integer userId,Integer productId,Integer count);
	
	ServerResponse<ShoppingCartVo> deleteProduct(Integer userId,Integer productId);
	
	ServerResponse<ShoppingCartVo> deleteProducts(Integer userId,Integer productIds);
	
	ServerResponse<ShoppingCartVo> list (Integer userId);
	
	ServerResponse<ShoppingCartVo> selectOrUnSelect (Integer userId,Integer productId,Integer checked);
	
	ServerResponse<Integer> getCartProductCount(Integer userId);
	
	void changeChecked(Integer userId,Integer productId);
	
	ServerResponse<List<ShoppingCart>> selectProductByChecked(Integer userId);
}
