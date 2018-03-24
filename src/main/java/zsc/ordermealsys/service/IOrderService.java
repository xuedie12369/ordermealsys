package zsc.ordermealsys.service;

import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;

@Service("iOrderService")
public interface IOrderService {
	public 	ServerResponse pay(Long orderID,Integer userID,String path);
	
}
