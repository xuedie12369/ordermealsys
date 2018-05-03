package zsc.ordermealsys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.pojo.ShoppingCart;
import zsc.ordermealsys.pojo.ShoppingCartExample;
@Service("shoppingCartMapper")
public interface ShoppingCartMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingCart record);
    
    int updateProductsBySelective(@Param("userId")Integer userId,@Param("productId")Integer productId,@Param("count")Integer count);

    int updateByPrimaryKey(ShoppingCart record);
    
    ShoppingCart selectCartByUserIdProductId(@Param("userId")Integer userId,@Param("productId")Integer productId);
    
    List<ShoppingCart> selectCartByUserIdAndProductId(@Param("userId")Integer userId,@Param("productId")Integer productId);
    
    List<ShoppingCart> selectCartByUserId(@Param("userId")Integer userId);
    
    int selectCartProductCheckedStatusByUserId(Integer userId);
    
    int deleteByUserIdProduct(@Param("userId")Integer userId, @Param("productId")Integer productId);
    
    int deleteByUserIdProductId(@Param("userId")Integer userId,@Param("productId")Integer productId);

    //根据用户ID和商品ID来删除购物车中的商品
//    int deleteByUserIdProductIds(@Param("userId")Integer userId,@Param("productIdList")List<Integer> productIdList);

    
    int checkedOrUncheckedProduct(@Param("userId")Integer userId,@Param("productId")Integer productId,@Param("checked")Integer checked);
    
    
    int selectCartProductCount(@Param("userId")Integer userId);
    
    List<ShoppingCart> selectCheckedCartByUserId(@Param("userId")Integer userId);
    
    
}