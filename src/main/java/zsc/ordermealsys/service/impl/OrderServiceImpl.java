package zsc.ordermealsys.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.ExtendParams;
import com.alipay.demo.trade.model.GoodsDetail;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.utils.ZxingUtils;
import com.google.common.collect.Maps;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.OrderItemMapper;
import zsc.ordermealsys.dao.OrderMapper;
import zsc.ordermealsys.dao.OrderPayMapper;
import zsc.ordermealsys.pojo.Order;
import zsc.ordermealsys.pojo.OrderItemWithBLOBs;
import zsc.ordermealsys.pojo.OrderPay;
import zsc.ordermealsys.service.IOrderService;
import zsc.ordermealsys.util.BigDecimalUtil;
import zsc.ordermealsys.util.DateTimeUtil;
import zsc.ordermealsys.util.PropertiesUtil;

@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {
	private static Log log = LogFactory.getLog(OrderServiceImpl.class);
	@Autowired
	OrderPayMapper orderPayMapper;
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	OrderItemMapper orderItemMapper;

	public Order selectByUserIdAndOrderId() {
		Order o = orderMapper.selectByPrimaryKey(1);
		System.out.print(o.getSellerName() + "卖家姓名");
		return null;
	}

	public int selectOrder() {
		int o = orderMapper.selectOrder();
		System.out.print(o);
		// System.out.print(o.getSellerName());
		return 23;
	}

	@Override
	public ServerResponse pay(Long order_no, Integer userId, String path) {
		// TODO Auto-generated method stub
		Map<String, String> resultMap = Maps.newHashMap();
		Order order = orderMapper.selectByUserIdAndOrderId(userId, order_no);
		if (order == null) {
			return ServerResponse.createByErrorMessage("用户没有该订单");
		}
		resultMap.put("orderNo", order.getOrderNo().toString());

		// 调用支付宝当面付功能
		String qrUrl = test_trade_precreate(order, userId, path);
		if (qrUrl == "" || qrUrl == null) {
			System.out.print("支付失败");
			return ServerResponse.createByErrorMessage("支付失败");
		}
		resultMap.put("qrUrl", qrUrl);
		return ServerResponse.createBySuccess(resultMap);

		/*
		 * List<OrderItemWithBLOBs> orderItemList
		 * =orderItemMapper.getByOrderNoAndUserId(1L, 11);
		 * for(OrderItemWithBLOBs orderItemWithBLOBs :orderItemList) {
		 * System.out.print(orderItemWithBLOBs.getPrice().toString()+"添加的"+
		 * orderItemWithBLOBs.getProductDetail()+"maij xingm ");
		 * 
		 * }
		 */
	}

	/**
	 * 支付宝支付后的回调函数 作者：邵海楠
	 * 
	 * @param params
	 * @return
	 */
	public ServerResponse aliCallback(Map<String, String> params) {
		Long orderNo = Long.parseLong(params.get("out_trade_no"));
		String tradeNo = params.get("trade_no");
		String tradeStatus = params.get("trade_status");
		Order order = orderMapper.selectByOrderNo(orderNo);
		if (order == null) {
			return ServerResponse.createByErrorMessage("非美食猎人的订单,回调忽略");
		}
		if (order.getPayStatus() >= Const.OrderStatusEnum.PAID.getCode()) {
			return ServerResponse.createBySuccess("支付宝重复调用");
		}
		if (Const.AlipayCallback.TRADE_STATUS_TRADE_SUCCESS.equals(tradeStatus)) {
			order.setPayTime(DateTimeUtil.strToDate(params.get("gmt_payment")));
			order.setPayStatus(Const.OrderStatusEnum.PAID.getCode());
			orderMapper.updateByPrimaryKeySelective(order);
		}

		OrderPay orderPay = new OrderPay();
		orderPay.setUserId(order.getUserId());
		orderPay.setOrderNo(order.getOrderNo());
		orderPay.setPayPlatformName(Const.PayPlatformEnum.ALIPAY.getCode());
		orderPay.setSerialNumber(tradeNo);
		orderPay.setPayStatus(tradeStatus);
		orderPayMapper.insert(orderPay);

		return ServerResponse.createBySuccess();
	}

	// 测试当面付2.0生成支付二维码
	public String test_trade_precreate(Order order, Integer userId, String path) {
		String qrfilePath = "";
		// (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
		// 需保证商户系统端不能重复，建议通过数据库sequence生成，
		String outTradeNo = order.getOrderNo().toString();

		// (必填) 订单标题，粗略描述用户的支付目的。如“xxx品牌xxx门店当面付扫码消费”
		String subject = new StringBuilder("订单编号:").append(order.getOrderNo()).toString();

		// (必填) 订单总金额，单位为元，不能超过1亿元
		// 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
		String totalAmount = order.getTotalPrice().toString();

		// (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
		// 如果该值未传入,但传入了【订单总金额】,【打折金额】,则该值默认为【订单总金额】-【打折金额】
		String undiscountableAmount = "0";

		// 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
		// 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
		String sellerId = "";

		// 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
		String body = new StringBuilder("订单编号:").append(order.getTotalPrice()).append("总计需要支付:")
				.append(order.getTotalPrice()).append("元").toString();

		// 商户操作员编号，添加此参数可以为商户操作员做销售统计
		String operatorId = "test_operator_id";

		// (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
		String storeId = "test_store_id";

		// 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
		ExtendParams extendParams = new ExtendParams();
		extendParams.setSysServiceProviderId("2088100200300400500");

		// 支付超时，定义为120分钟
		String timeoutExpress = "120m";

		// 商品明细列表，需填写购买商品详细信息，
		List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();

		// 自己加的部分
		List<OrderItemWithBLOBs> orderItemList = new ArrayList<OrderItemWithBLOBs>();
		orderItemList = orderItemMapper.getByOrderNoAndUserId(order.getOrderNo(), userId);

		for (OrderItemWithBLOBs orderItem : orderItemList) {
			// 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
			GoodsDetail goods1 = GoodsDetail.newInstance(orderItem.getOrderNo().toString(), orderItem.getName(),
					BigDecimalUtil.mul(orderItem.getPrice().doubleValue(), new Double(100).doubleValue()).longValue(),
					orderItem.getNum());
			// 创建好一个商品后添加至商品明细列表
			goodsDetailList.add(goods1);
		}

		/*
		 * // 继续创建并添加第一条商品信息，用户购买的产品为“黑人牙刷”，单价为5.00元，购买了两件 GoodsDetail goods2 =
		 * GoodsDetail.newInstance("goods_id002", "xxx牙刷", 500, 2);
		 * goodsDetailList.add(goods2);
		 */

		// 创建扫码支付请求builder，设置请求参数
		AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder().setSubject(subject)
				.setTotalAmount(totalAmount).setOutTradeNo(outTradeNo).setUndiscountableAmount(undiscountableAmount)
				.setSellerId(sellerId).setBody(body).setOperatorId(operatorId).setStoreId(storeId)
				.setExtendParams(extendParams).setTimeoutExpress(timeoutExpress)
				.setNotifyUrl(PropertiesUtil.getProperty("alipay.callback.url"))// 支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
				.setGoodsDetailList(goodsDetailList);

		// 加载属性配置文件（从demo的main类的static块复制来的）
		/**
		 * 一定要在创建AlipayTradeService之前调用Configs.init()设置默认参数
		 * Configs会读取classpath下的zfbinfo.properties文件配置信息，
		 * 如果找不到该文件则确认该文件是否在classpath目录
		 */
		Configs.init("zfbinfo.properties");

		/**
		 * 使用Configs提供的默认参数 AlipayTradeService可以使用单例或者为静态成员对象，不需要反复new
		 */
		AlipayTradeService tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();

		AlipayF2FPrecreateResult result = tradeService.tradePrecreate(builder);
		switch (result.getTradeStatus()) {
		case SUCCESS:
			log.info("支付宝预下单成功: )");

			AlipayTradePrecreateResponse response = result.getResponse();
			dumpResponse(response);

			// 自己加的部分，集成特别重要的部分
			File folder = new File(path);
			if (!folder.exists()) {
				folder.setWritable(true);
				folder.mkdirs();
			}

			// 需要修改为运行机器上的路径
			qrfilePath = String.format(path + "/qr-%s.png", response.getOutTradeNo());
			System.out.print("生成的二维码路径为:" + qrfilePath);

			ZxingUtils.getQRCodeImge(response.getQrCode(), 256, qrfilePath);

			// 没有写把二维码上传到ftp服务器的代码，待完善
			log.info("filePath:" + qrfilePath);
			// ZxingUtils.getQRCodeImge(response.getQrCode(), 256, filePath);
			break;

		case FAILED:
			log.error("支付宝预下单失败!!!");

			break;

		case UNKNOWN:
			log.error("系统异常，预下单状态未知!!!");
			break;

		default:
			log.error("不支持的交易状态，交易返回异常!!!");
			break;
		}
		return qrfilePath;
	}

	// 简单打印应答
	private void dumpResponse(AlipayResponse response) {
		if (response != null) {
			log.info(String.format("code:%s, msg:%s", response.getCode(), response.getMsg()));
			if (StringUtils.isNotEmpty(response.getSubCode())) {
				log.info(String.format("subCode:%s, subMsg:%s", response.getSubCode(), response.getSubMsg()));
			}
			log.info("body:" + response.getBody());
		}
	}

	@Override
	public ServerResponse queryOrderPayStatus(Integer userId, Long orderNo) {
		// TODO Auto-generated method stub
		
	  Order	 order=orderMapper.selectByUserIdAndOrderId(userId, orderNo);
	  System.out.print("订单是:"+order.getSellerName());
	  if(order == null){
          return ServerResponse.createByErrorMessage("用户没有该订单");
      }
      if(order.getOrderStatus() >= Const.OrderStatusEnum.PAID.getCode()){
          return ServerResponse.createBySuccess();
      }
      return ServerResponse.createByError();
	}

}
