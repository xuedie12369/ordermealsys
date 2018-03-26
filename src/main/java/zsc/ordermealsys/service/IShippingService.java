package zsc.ordermealsys.service;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.Address;

public interface IShippingService {
	ServerResponse add(Integer session,Address address);
	ServerResponse<String> del(Integer userId,Integer addressId);
	ServerResponse update(Integer userId,Address address);
	ServerResponse<Address> select(Integer userId,Integer addressId);
	ServerResponse<PageInfo>list(Integer userId,int pageNum,int pageSize);
}
