package zsc.ordermealsys.dao;

import zsc.ordermealsys.pojo.DeliveryFee;

public interface DeliveryFeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryFee record);

    int insertSelective(DeliveryFee record);

    DeliveryFee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliveryFee record);

    int updateByPrimaryKey(DeliveryFee record);
}