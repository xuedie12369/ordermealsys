package zsc.ordermealsys.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.pojo.Order;
@Service("orderMapper")
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);
    int selectOrder();

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    //自写部分
    Order selectByUserIdAndOrderId(@Param("userId")Integer userId,@Param("order_no")Long order_no);
    
    Order selectByOrderNo(Long order_no);
}