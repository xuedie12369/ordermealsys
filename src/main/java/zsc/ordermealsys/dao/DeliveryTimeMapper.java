package zsc.ordermealsys.dao;

import zsc.ordermealsys.pojo.DeliveryTime;

public interface DeliveryTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryTime record);

    int insertSelective(DeliveryTime record);

    DeliveryTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliveryTime record);

    int updateByPrimaryKey(DeliveryTime record);
}