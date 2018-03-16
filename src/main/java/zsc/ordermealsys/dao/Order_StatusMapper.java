package zsc.ordermealsys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zsc.ordermealsys.pojo.Order_Status;
import zsc.ordermealsys.pojo.Order_StatusExample;

public interface Order_StatusMapper {
    int countByExample(Order_StatusExample example);

    int deleteByExample(Order_StatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order_Status record);

    int insertSelective(Order_Status record);

    List<Order_Status> selectByExample(Order_StatusExample example);

    Order_Status selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order_Status record, @Param("example") Order_StatusExample example);

    int updateByExample(@Param("record") Order_Status record, @Param("example") Order_StatusExample example);

    int updateByPrimaryKeySelective(Order_Status record);

    int updateByPrimaryKey(Order_Status record);
}