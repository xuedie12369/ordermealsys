package zsc.ordermealsys.dao;

import zsc.ordermealsys.pojo.StorePic;
import zsc.ordermealsys.pojo.StorePicWithBLOBs;

public interface StorePicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StorePicWithBLOBs record);

    int insertSelective(StorePicWithBLOBs record);

    StorePicWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StorePicWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(StorePicWithBLOBs record);

    int updateByPrimaryKey(StorePic record);
}