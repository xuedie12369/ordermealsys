package zsc.ordermealsys.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.Address;

@Service("iShippingService")
public interface IShippingService {
	ServerResponse add(Integer session,Address address);
	ServerResponse<String> del(Integer userId,Integer addressId);
	ServerResponse update(Integer userId,Address address);
	ServerResponse<Address> select(Integer userId,Integer addressId);
	ServerResponse<PageInfo>list(Integer userId,int pageNum,int pageSize);
	ServerResponse<List<Address>> selectAllAddressByUserId(Integer userId);
}
