package zsc.ordermealsys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zsc.ordermealsys.pojo.Order_Pay;
import zsc.ordermealsys.pojo.Order_PayExample;

public interface Order_PayMapper {
    int countByExample(Order_PayExample example);

    int deleteByExample(Order_PayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order_Pay record);

    int insertSelective(Order_Pay record);

    List<Order_Pay> selectByExample(Order_PayExample example);

    Order_Pay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order_Pay record, @Param("example") Order_PayExample example);

    int updateByExample(@Param("record") Order_Pay record, @Param("example") Order_PayExample example);

    int updateByPrimaryKeySelective(Order_Pay record);

    int updateByPrimaryKey(Order_Pay record);
}