package zsc.ordermealsys.service;

import org.springframework.stereotype.Service;
import zsc.ordermealsys.common.ServerResponse;

@Service("iAdminService")
public interface IAdminService {
	ServerResponse<String> queryuser(String username);
}
