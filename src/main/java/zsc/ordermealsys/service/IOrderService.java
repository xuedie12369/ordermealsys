package zsc.ordermealsys.service;

import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.Order;
@Service("iOrderService")
public interface IOrderService {
	Order selectByUserIdAndOrderId();
	int selectOrder();
	ServerResponse pay(Long order_no, Integer userId, String path);
}
