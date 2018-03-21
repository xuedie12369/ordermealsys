package zsc.ordermealsys.service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.vo.ShoppingCartVo;

public interface ICartService {
	ServerResponse<ShoppingCartVo> add(Integer userId,Integer productId,Integer count);
}
