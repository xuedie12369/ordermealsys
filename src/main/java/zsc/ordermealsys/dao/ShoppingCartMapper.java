package zsc.ordermealsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zsc.ordermealsys.pojo.ShoppingCart;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
    
    ShoppingCart selectCartByUserIdProductId(@Param("userId")Integer userId,@Param("productId")Integer productId);
    
    List<ShoppingCart>selectCartByUserId(Integer userId);
    
    int selectCartProductCheckedStatusByUserId(Integer userId);
}