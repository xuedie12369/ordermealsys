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

	//获取购物车下单数量的限制
	private ShoppingCartVo getShoppingCartVoLimit(Integer userId){
		ShoppingCartVo cartVo=new ShoppingCartVo();
		List<ShoppingCart>cartList=shoppingCartMapper.selectCartByUserId(userId);
		List<CartProductVo>cartProductVoList=Lists.newArrayList();
		BigDecimal cartTotalPrice=new BigDecimal("0");

		if(CollectionUtils.isNotEmpty(cartList)){
			for(ShoppingCart cartItem:cartList){
				//for(object a:list)循环取出list中的每一个元素
				CartProductVo cartProductVo=new CartProductVo();
				cartProductVo.setId(cartItem.getId());
				cartProductVo.setUserId(userId);
				cartProductVo.setProductId(cartItem.getProductId());
				ProductWithBLOBs product=productMapper.
						selectByPrimaryKey(cartItem.getProductId());
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
						cartProductVo.
						setLimitQuantity(Const.ShoppingCart.LIMIT_NUM_SUCCESS);
					}else{
						//库存不足时将菜品库存量更新到购买限制数量
						buyLimitCount = product.getStock();
						cartProductVo.setLimitQuantity(Const.
								ShoppingCart.LIMIT_NUM_FAIL);
						//购物车中更新有效库存
						ShoppingCart cartForNum = new ShoppingCart();
						cartForNum.setId(cartItem.getId());
						cartForNum.setProductNum(buyLimitCount);
						shoppingCartMapper.updateByPrimaryKeySelective(cartForNum);
					}
					cartProductVo.setProductNum(buyLimitCount);
					cartProductVo.setProductChecked(cartItem.getChecked());				
					cartItem.setChecked(1);
				}
				cartProductVoList.add(cartProductVo);	
			}
		}
		cartVo.setCartTotalPrice(cartTotalPrice);
		System.out.println("总价为："+cartVo.getCartTotalPrice().toString());
		cartVo.setCartProductVoList(cartProductVoList);
		cartVo.setAllChecked(this.getAllCheckedStatus(userId));//判断是否全选
		cartVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));
		return cartVo;
	}

	//判断购物车中的菜品是否被全选
	private boolean getAllCheckedStatus(Integer userId){
		if(userId == null){
			return false;
		}
		return shoppingCartMapper.selectCartProductCheckedStatusByUserId(userId) == 0;
	}
	
	//购物车中菜品的查询功能（查）
	public ServerResponse<ShoppingCartVo> list (Integer userId){
		ShoppingCartVo cartVo = this.getShoppingCartVoLimit(userId);
		System.out.println("购物车查找成功");
		System.out.println(cartVo.getCartTotalPrice().toString());
		return ServerResponse.createBySuccess(cartVo);
	}
	
	//购物车添加菜品功能（增）
	public ServerResponse<ShoppingCartVo> add(Integer userId,Integer productId,Integer count){
		
		//校验productId和count是否为空，若为空则返回参数错误
		if(productId == null || count == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.
            		getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
		
		ShoppingCart cart=shoppingCartMapper.selectCartByUserIdProductId(userId, productId);
	
		if(cart==null){
			Product product=productMapper.selectByPrimaryKey(productId);
			//这个菜品不在这个购物车里，需要新增一个这个菜品的记录
			ShoppingCart cartItem=new ShoppingCart();
			cartItem.setProductNum(count);
			cartItem.setChecked(Const.ShoppingCart.UN_CHECKED);
			cartItem.setProductId(productId);
			cartItem.setUserId(userId);
			cartItem.setProductPrice(product.getPrice());
			System.out.println("123456");
			System.out.println(cartItem.toString()+"规划局 ");
			shoppingCartMapper.insert(cartItem);
			
		}else{
			//这个产品已经在购物车里了
			//如果产品已存在，数量相加
			count=cart.getProductNum()+count;
			shoppingCartMapper.updateProductsBySelective(userId,productId,count);
		}
		return this.list(userId);
	}
	
	//更新购物车中菜品的功能（改）
	public ServerResponse<ShoppingCartVo> update(Integer userId,Integer productId,Integer count){
		if(productId == null || count == null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.
					getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		ShoppingCart cart = shoppingCartMapper.selectCartByUserIdProductId(userId,productId);
		if(cart != null){
			cart.setProductNum(count);
		}
		shoppingCartMapper.updateByPrimaryKeySelective(cart);
		System.out.println("购物车中菜品修改成功");
		//shoppingCartMapper.updateByPrimaryKey(cart);
		return this.list(userId);
	}

	//删除购物车中菜品（一个）的功能（删）
	public ServerResponse<ShoppingCartVo> deleteProduct(Integer userId,Integer productId){
		ShoppingCart product=shoppingCartMapper.selectCartByUserIdProductId(userId, productId);
		if(product==null){
			return ServerResponse.createByErrorMessage("未查到相关菜品！");
		}else{
			shoppingCartMapper.deleteByUserIdProductId(userId, productId);
		}
		return ServerResponse.createBySuccessMessage("删除成功！");
	}
	
	//删除购物车中指定菜品（多个）的功能（删）
	public ServerResponse<ShoppingCartVo> deleteProducts(Integer userId,Integer productId){
		List<ShoppingCart> productList=shoppingCartMapper.
				selectCartByUserIdAndProductId(userId, productId);
		if(productList.isEmpty()){
			return ServerResponse.createByErrorMessage("未查到相关菜品！");
		}else{
			for(int i=0;i<productList.size();i++){
				shoppingCartMapper.deleteByUserIdProductId(userId, productList.get(i).getProductId());
			}
			System.out.println("删除成功");
			return ServerResponse.createBySuccessMessage("删除成功！");
		}
		
	}
	
	//改变购物车中菜品的选中状态
	public void updatethechecked(Integer userId,Integer productId){
		ShoppingCart cart=shoppingCartMapper.selectCartByUserIdProductId(userId, productId);
		
//		System.out.println(cart.getProductId().toString());
		int checked=cart.getChecked();
		if(checked==1){
			cart.setChecked(0);
		}else{
			cart.setChecked(1);
		}
		shoppingCartMapper.changethechecked(userId, productId, cart.getChecked());
		System.out.println("修改完成");
	}
	
//	public ServerResponse<ShoppingCartVo> deleteProduct(Integer userId,String productIds){
//		
//		List<String> productList = Splitter.on(",").splitToList(productIds);
//		if(CollectionUtils.isEmpty(productList)){
//			return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
//		}
//		shoppingCartMapper.deleteByUserIdProductIds(userId,productList);
//		System.out.println("购物车删除成功");
//		return this.list(userId);
//	}
	
	//
	public ServerResponse<ShoppingCartVo> selectOrUnSelect (Integer userId,Integer productId,Integer checked){
		shoppingCartMapper.checkedOrUncheckedProduct(userId,productId,checked);
		return this.list(userId);
	}

	//获取购物车中商品的数量
	public ServerResponse<Integer> getCartProductCount(Integer userId){
		if(userId == null){
			return ServerResponse.createBySuccess(0);
		}
		return ServerResponse.createBySuccess(shoppingCartMapper.selectCartProductCount(userId));
	}


	







	
	
	
	


}
