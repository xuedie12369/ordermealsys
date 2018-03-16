package zsc.ordermealsys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zsc.ordermealsys.pojo.Order_Item;
import zsc.ordermealsys.pojo.Order_ItemExample;
import zsc.ordermealsys.pojo.Order_ItemWithBLOBs;

public interface Order_ItemMapper {
    int countByExample(Order_ItemExample example);

    int deleteByExample(Order_ItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order_ItemWithBLOBs record);

    int insertSelective(Order_ItemWithBLOBs record);

    List<Order_ItemWithBLOBs> selectByExampleWithBLOBs(Order_ItemExample example);

    List<Order_Item> selectByExample(Order_ItemExample example);

    Order_ItemWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order_ItemWithBLOBs record, @Param("example") Order_ItemExample example);

    int updateByExampleWithBLOBs(@Param("record") Order_ItemWithBLOBs record, @Param("example") Order_ItemExample example);

    int updateByExample(@Param("record") Order_Item record, @Param("example") Order_ItemExample example);

    int updateByPrimaryKeySelective(Order_ItemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(Order_ItemWithBLOBs record);

    int updateByPrimaryKey(Order_Item record);
}