package zsc.ordermealsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
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
    Order selectByUserIdAndOrderNo(@Param("userId")Integer userId,@Param("orderNo")Long orderNo);
    
    Order selectByOrderNo(Long order_no);
    
    List<Order> selectByUserId(@Param("userId")Integer userId);
    
    List<Order> selectAllOrder();
}