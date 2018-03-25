package zsc.ordermealsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.AddressMapper;
import zsc.ordermealsys.pojo.Address;
import zsc.ordermealsys.service.IShippingService;

@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService{
	
	@Autowired
	private AddressMapper addressMapper;
	
	public ServerResponse add(Integer userId,Address address){
		//address.set
		int rowCount=addressMapper.insert(address);
		
	}
}
