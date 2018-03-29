package zsc.ordermealsys.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.Order;
@Service("iOrderService")
public interface IOrderService {
	Order selectByUserIdAndOrderId();
	int selectOrder();
	ServerResponse pay(Long order_no, Integer userId, String path);


	ServerResponse createOrder(Integer userId);

	public ServerResponse aliCallback(Map<String, String> params);
	public ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);

}
