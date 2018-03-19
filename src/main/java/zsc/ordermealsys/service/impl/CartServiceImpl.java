package zsc.ordermealsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.ShoppingCartMapper;
import zsc.ordermealsys.pojo.ShoppingCart;
import zsc.ordermealsys.service.ICartService;

public class CartServiceImpl implements ICartService{
	
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	
	public ServerResponse add(String buyerName,Integer productId,Integer count){
		ShoppingCart cart=shoppingCartMapper.selectCartByUserIdProductId(buyerName, productId);
		if(cart==null){
			//这个商品不在这个购物车里，需要新增一个这个商品的记录
			ShoppingCart cartItem=new ShoppingCart();
			cartItem.setProductNum(count);
			cartItem.
		}
	}
}
