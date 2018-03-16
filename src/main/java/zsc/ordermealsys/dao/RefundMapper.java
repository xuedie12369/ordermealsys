package zsc.ordermealsys.dao;

import zsc.ordermealsys.pojo.Refund;

public interface RefundMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Refund record);

    int insertSelective(Refund record);

    Refund selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);
}