package zsc.ordermealsys.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.ProductMapper;
import zsc.ordermealsys.dao.ShoppingCartMapper;
import zsc.ordermealsys.pojo.Product;
import zsc.ordermealsys.pojo.ShoppingCart;
import zsc.ordermealsys.service.ICartService;
import zsc.ordermealsys.vo.CartProductVo;
import zsc.ordermealsys.vo.ShoppingCartVo;

public class CartServiceImpl implements ICartService{
	
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	@Autowired
	private ProductMapper productMapper;
	
	public ServerResponse add(String buyerName,Integer productId,Integer count){
		ShoppingCart cart=shoppingCartMapper.selectCartByUserIdProductId(buyerName, productId);
		if(cart==null){
			//这个商品不在这个购物车里，需要新增一个这个商品的记录
			ShoppingCart cartItem=new ShoppingCart();
			cartItem.setProductNum(count);
			cartItem.setChecked(Const.shoppingCart.CHECKED);
			cartItem.setProductId(productId);
			cartItem.setBuyerName(buyerName);
			shoppingCartMapper.insert(cartItem);
		}else{
			//这个产品已经在购物车里了
			//如果产品已存在，数量相加
			count=cart.getProductNum()+count;
			cart.setProductNum(count);
			shoppingCartMapper.updateByPrimaryKeySelective(cart);
		}
		return null;
	}
	
	private ShoppingCartVo getShoppingCartVoLimit(String buyer_name){
		ShoppingCartVo cartVo=new ShoppingCartVo();
		List<ShoppingCart>cartList=shoppingCartMapper.selectCartByBuyerName(buyer_name);
		List<CartProductVo>cartProductVoList=Lists.newArrayList();
		
		BigDecimal cartTotalPrice=new BigDecimal("0");
		
		if(CollectionUtils.isNotEmpty(cartList)){
			for(ShoppingCart cartItem:cartList){
				CartProductVo cartProductVo=new CartProductVo();
				cartProductVo.setId(cartItem.getId());
				cartProductVo.setBuyerName(buyer_name);
//				cartProductVo.setUserId(userId);
				cartProductVo.setProductId(cartItem.getProductId());
				
				Product product=
			}
		}
		
	}
}
