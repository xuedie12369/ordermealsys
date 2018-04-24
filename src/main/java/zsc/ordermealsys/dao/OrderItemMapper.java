package zsc.ordermealsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zsc.ordermealsys.pojo.OrderItem;
import zsc.ordermealsys.pojo.OrderItemWithBLOBs;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItemWithBLOBs record);

    int insertSelective(OrderItemWithBLOBs record);

    OrderItemWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrderItemWithBLOBs record);

    int updateByPrimaryKey(OrderItem record);
    
    //自写部分
    List<OrderItemWithBLOBs> getByOrderNoAndUserId(@Param("orderNo")Long orderNo,@Param("userId")Integer userId);
    
    void batchInsert(@Param("orderItemList")List<OrderItemWithBLOBs> orderItemList);
}