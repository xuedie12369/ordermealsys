package zsc.ordermealsys.dao;

import zsc.ordermealsys.pojo.RefundPic;

public interface RefundPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RefundPic record);

    int insertSelective(RefundPic record);

    RefundPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RefundPic record);

    int updateByPrimaryKeyWithBLOBs(RefundPic record);

    int updateByPrimaryKey(RefundPic record);
}