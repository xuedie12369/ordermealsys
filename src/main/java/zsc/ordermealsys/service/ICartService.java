package zsc.ordermealsys.service;

import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.vo.ShoppingCartVo;

@Service("iCartService")
public interface ICartService {
	
	ServerResponse<ShoppingCartVo> add(Integer userId,Integer productId,Integer count);
	
	ServerResponse<ShoppingCartVo> update(Integer userId,Integer productId,Integer count);
	
	ServerResponse<ShoppingCartVo> deleteProduct(Integer userId,String productIds);
	
	ServerResponse<ShoppingCartVo> list (Integer userId);
	
	ServerResponse<ShoppingCartVo> selectOrUnSelect (Integer userId,Integer productId,Integer checked);
	
	ServerResponse<Integer> getCartProductCount(Integer userId);
}
