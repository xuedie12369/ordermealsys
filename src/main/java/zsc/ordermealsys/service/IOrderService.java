package zsc.ordermealsys.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.Order;
import zsc.ordermealsys.vo.OrderVo;
@Service("iOrderService")
public interface IOrderService {
	Order selectByUserIdAndOrderId();
	
	int selectOrder();
	
	ServerResponse pay(Long order_no, Integer userId, String path);
	
	ServerResponse createOrder(Integer userId);

	public ServerResponse aliCallback(Map<String, String> params);
	
	public ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);
	
	ServerResponse<String> cancel(Integer userId,Long orderNo);
	
	ServerResponse getOrderCartProduct(Integer integer);
	
	ServerResponse<OrderVo> getOrderDetail(Integer userId,Long orderNo);
	
	 //backend
    ServerResponse<PageInfo> manageList(int pageNum,int pageSize);
    ServerResponse<OrderVo> manageDetail(Long orderNo);
    ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int pageSize);
    ServerResponse<String> manageSendGoods(Long orderNo);
}
