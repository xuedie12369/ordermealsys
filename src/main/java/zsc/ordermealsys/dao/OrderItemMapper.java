package zsc.ordermealsys.dao;

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
}