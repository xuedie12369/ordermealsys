package zsc.ordermealsys.service;

import javax.servlet.http.HttpSession;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.Address;

public interface IShippingService {
	ServerResponse add(Integer session,Address address);
}
