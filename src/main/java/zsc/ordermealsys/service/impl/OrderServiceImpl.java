package zsc.ordermealsys.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.OrderMapper;
import zsc.ordermealsys.pojo.Order;
import zsc.ordermealsys.service.IOrderService;
@Service("orderServiceImpl")
public class OrderServiceImpl  implements IOrderService {
	@Autowired
	OrderMapper   	orderMapper;
	@Override
	public ServerResponse pay(Long orderId, Integer userId, String path) {
		// TODO Auto-generated method stub
		Map<String,String> resultMap=Maps.newHashMap();
	 Order o=orderMapper.selectByUserIDAndOrderId(userId, orderId);
		System.out.print(o.getSellerName()+o.getUserId());
		
		
		return null;
	}

	
}
