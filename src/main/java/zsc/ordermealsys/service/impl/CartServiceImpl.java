package zsc.ordermealsys.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.ProductMapper;
import zsc.ordermealsys.dao.ShoppingCartMapper;
import zsc.ordermealsys.pojo.Product;
import zsc.ordermealsys.pojo.ProductWithBLOBs;
import zsc.ordermealsys.pojo.ShoppingCart;
import zsc.ordermealsys.service.ICartService;
import zsc.ordermealsys.util.BigDecimalUtil;
import zsc.ordermealsys.util.PropertiesUtil;
import zsc.ordermealsys.vo.CartProductVo;
import zsc.ordermealsys.vo.ShoppingCartVo;

@Service("iCartService")
public class CartServiceImpl implements ICartService{

	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	@Autowired
	private ProductMapper productMapper;

	private ShoppingCartVo getShoppingCartVoLimit(Integer userId){
		ShoppingCartVo cartVo=new ShoppingCartVo();
		List<ShoppingCart>cartList=shoppingCartMapper.selectCartByUserId(userId);
		List<CartProductVo>cartProductVoList=Lists.newArrayList();
		BigDecimal cartTotalPrice=new BigDecimal("0");

		if(CollectionUtils.isNotEmpty(cartList)){
			for(ShoppingCart cartItem:cartList){//for(object a:list)循环取出list中的每一个元素
				CartProductVo cartProductVo=new CartProductVo();
				cartProductVo.setId(cartItem.getId());
				cartProductVo.setUserId(userId);
				cartProductVo.setProductId(cartItem.getProductId());
				ProductWithBLOBs product=productMapper.selectByPrimaryKey(cartItem.getProductId());
				if(product!=null){
					cartProductVo.setProductMainPic(product.getMainPic());
					cartProductVo.setProductName(product.getName());
					cartProductVo.setProductStatus(product.getProStatus());
					cartProductVo.setProductPrice(product.getPrice());
					cartProductVo.setProductStock(product.getStock());
					//判断库存
					int buyLimitCount = 0;
					if(product.getStock() >= cartItem.getProductNum()){
						//库存充足的时候
						buyLimitCount = cartItem.getProductNum();
						cartProductVo.setLimitQuantity(Const.ShoppingCart.LIMIT_NUM_SUCCESS);
					}else{
						//库存不足时将商品库存量更新到购买限制数量
						buyLimitCount = product.getStock();
						cartProductVo.setLimitQuantity(Const.ShoppingCart.LIMIT_NUM_FAIL);
						//购物车中更新有效库存
						ShoppingCart cartForNum = new ShoppingCart();
						cartForNum.setId(cartItem.getId());
						cartForNum.setProductNum(buyLimitCount);
						shoppingCartMapper.updateByPrimaryKeySelective(cartForNum);
					}
					cartProductVo.setProductNum(buyLimitCount);
					//计算总价
					cartProductVo.setProductTotalPrice(BigDecimalUtil.mul(product.getPrice().doubleValue(),cartProductVo.getProductNum()));
					cartProductVo.setProductChecked(cartItem.getChecked());
					
					
					
					cartItem.setChecked(1);
				}
				if(cartItem.getChecked() == Const.ShoppingCart.CHECKED){
					//如果已经勾选,增加到整个的购物车总价中
					cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(),cartProductVo.getProductTotalPrice().doubleValue());
				}
				cartProductVoList.add(cartProductVo);	
			}
		}
		cartVo.setCartTotalPrice(cartTotalPrice);
		cartVo.setCartProductVoList(cartProductVoList);
		//cartVo.setAllChecked(this.getAllCheckedStatus(userId));//判断是否全选
		cartVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));
		return cartVo;
	}

	
	private boolean getAllCheckedStatus(Integer userId){
		if(userId == null){
			return false;
		}
		return shoppingCartMapper.selectCartProductCheckedStatusByUserId(userId) == 0;
	}
	
	
	
	
	
	public ServerResponse<ShoppingCartVo> add(Integer userId,Integer productId,Integer count){
		//校验productId和count是否为空，若为空则返回参数错误
		if(productId == null || count == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
		
		ShoppingCart cart=shoppingCartMapper.selectCartByUserIdProductId(userId, productId);
		if(cart==null){
			//这个商品不在这个购物车里，需要新增一个这个商品的记录
			ShoppingCart cartItem=new ShoppingCart();
			cartItem.setProductNum(count);
			cartItem.setChecked(Const.ShoppingCart.CHECKED);
			cartItem.setProductId(productId);
			cartItem.setUserId(userId);
			shoppingCartMapper.insert(cartItem);
		}else{
			//这个产品已经在购物车里了
			//如果产品已存在，数量相加
			count=cart.getProductNum()+count;
			cart.setProductNum(count);
			shoppingCartMapper.updateByPrimaryKeySelective(cart);
		}
		ShoppingCartVo shoppingCartVo=this.getShoppingCartVoLimit(userId);
		System.out.println("添加记录成功");
		return ServerResponse.createBySuccess(shoppingCartVo);
		//return this.list(userId);
		
		//return null;
	}
	
	
	
	
	/*public ServerResponse<ShoppingCartVo> update(Integer userId,Integer productId,Integer count){
		if(productId == null || count == null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		ShoppingCart cart = shoppingCartMapper.selectCartByUserIdProductId(userId,productId);
		if(cart != null){
			cart.setProductNum(count);
		}
		shoppingCartMapper.updateByPrimaryKey(cart);
		return this.list(userId);
	}

	public ServerResponse<ShoppingCartVo> deleteProduct(Integer userId,String productIds){
		List<String> productList = Splitter.on(",").splitToList(productIds);
		if(CollectionUtils.isEmpty(productList)){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		shoppingCartMapper.deleteByUserIdProductIds(userId,productList);
		return this.list(userId);
	}


	public ServerResponse<ShoppingCartVo> list (Integer userId){
		ShoppingCartVo cartVo = this.getCartVoLimit(userId);
		return ServerResponse.createBySuccess(cartVo);
	}



	public ServerResponse<ShoppingCartVo> selectOrUnSelect (Integer userId,Integer productId,Integer checked){
		shoppingCartMapper.checkedOrUncheckedProduct(userId,productId,checked);
		return this.list(userId);
	}

	public ServerResponse<Integer> getCartProductCount(Integer userId){
		if(userId == null){
			return ServerResponse.createBySuccess(0);
		}
		return ServerResponse.createBySuccess(shoppingCartMapper.selectCartProductCount(userId));
	}
*/









	
	
	
	


}
