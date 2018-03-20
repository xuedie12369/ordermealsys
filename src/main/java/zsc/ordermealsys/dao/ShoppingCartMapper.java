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
    
    ShoppingCart selectCartByUserIdProductId(@Param("buyerName")String buyerName,@Param("productId")Integer productId);
    
    List<ShoppingCart>selectCartByBuyerName(String buyer_name);
}