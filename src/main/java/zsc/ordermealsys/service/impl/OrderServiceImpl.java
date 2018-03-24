package zsc.ordermealsys.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.OrderMapper;
import zsc.ordermealsys.pojo.Order;
import zsc.ordermealsys.service.IOrderService;
@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {
	@Autowired
	OrderMapper orderMapper;
	public Order selectByUserIdAndOrderId()
	{	
	Order o=orderMapper.selectByPrimaryKey(1);
	System.out.print(o.getSellerName()+"卖家姓名");
		return null;
	}
	public int selectOrder()
	{	
	int o=orderMapper.selectOrder();
	System.out.print(o);
//	System.out.print(o.getSellerName());
		return 23;
	}
	@Override
	public ServerResponse pay(Long order_no, Integer userId, String path) {
		// TODO Auto-generated method stub
		Map<String ,String> resultMap = Maps.newHashMap();
		Order order = orderMapper.selectByUserIdAndOrderId(userId,order_no);
		System.out.print(order.getSellerName());
		 if(order == null){
	            return ServerResponse.createByErrorMessage("用户没有该订单");
	        }
		
		return null;
	}
}
