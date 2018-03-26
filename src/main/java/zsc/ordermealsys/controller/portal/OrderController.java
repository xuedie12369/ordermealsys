package zsc.ordermealsys.controller.portal;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.demo.trade.config.Configs;
import com.google.common.collect.Maps;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.IOrderService;

@Controller
@RequestMapping("/order/")
public class OrderController {
	@Autowired
	private IOrderService iOrderService;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(OrderController.class);

	// 邵海楠部分
	/**
	 * 订单支付 作者：邵海楠
	 * 
	 * @param session
	 * @param orderId
	 * @param request
	 * @return
	 */
	@RequestMapping("pay.do")
	@ResponseBody
	public ServerResponse pay(HttpSession session, Long orderId, HttpServletRequest request) {
		User user = (User) session.getAttribute(Const.CURRENT_USER);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),
					ResponseCode.NEED_LOGIN.getDesc());
		}
		String path = request.getSession().getServletContext().getRealPath("upload");
		return iOrderService.pay(orderId, user.getId(), path);
	}

	@RequestMapping("alipay_callback.do")
	@ResponseBody
	public Object alipayCallback(HttpServletRequest request) {

		Map<String, String> params = Maps.newHashMap();
		Map requestParams = request.getParameterMap();

		Iterator iter = requestParams.keySet().iterator();
		while (iter.hasNext()) {
			// 获取键值
			String name = (String) iter.next();
			// 获取值
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			params.put(name, valueStr);

		}
		logger.info("支付宝回调,sign:{},trade_status:{},参数:{}", params.get("sign"), params.get("trade_status"),
				params.toString());

		// 非常重要,验证回调的正确性,是不是支付宝发的.并且呢还要避免重复通知.
		// 必须删除sign_type和sign（sign_type在 官方的sdk里面系统已经自动删除）

		params.remove("sign_type");
		try {
			boolean alipayRSACheckedV2 = AlipaySignature.rsaCheckV2(params, Configs.getAlipayPublicKey(), "utf-8",
					Configs.getSignType());
			if (!alipayRSACheckedV2) {
				return ServerResponse.createByErrorMessage("非法请求,验证不通过,再恶意请求我就报警找网警了");
			}

		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			logger.error("支付宝验证回调异常", e);
			e.printStackTrace();
		}
//to  do 验证各种数据
		ServerResponse serverResponse=iOrderService.aliCallback(params);
		if(serverResponse.isSuccess())
		{
			return Const.AlipayCallback.RESPONSE_SUCCESS;
		}
		
		return Const.AlipayCallback.RESPONSE_SUCCESS;
	}
		
	/**
	 * 查询订单状态
	 * 作者:邵海楠
	 * @param session
	 * @param orderNo
	 * @return
	 */
	
	 @RequestMapping("query_order_pay_status.do")
	    @ResponseBody
	    public ServerResponse<Boolean> queryOrderPayStatus(HttpSession session, Long orderNo){
	        User user = (User)session.getAttribute(Const.CURRENT_USER);
	        if(user ==null){
	            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
	        }

	        ServerResponse serverResponse = iOrderService.queryOrderPayStatus(user.getId(),orderNo);
	        if(serverResponse.isSuccess()){
	            return ServerResponse.createBySuccess(true);
	        }
	        return ServerResponse.createBySuccess(false);
	    }

}
