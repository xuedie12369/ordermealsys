package zsc.ordermealsys.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alipay.api.AlipayResponse;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.ExtendParams;
import com.alipay.demo.trade.model.GoodsDetail;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.utils.ZxingUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.OrderItemMapper;
import zsc.ordermealsys.dao.OrderMapper;
import zsc.ordermealsys.dao.OrderPayMapper;
import zsc.ordermealsys.dao.ProductMapper;
import zsc.ordermealsys.dao.ShoppingCartMapper;
import zsc.ordermealsys.dao.UserMapper;
import zsc.ordermealsys.pojo.Order;
import zsc.ordermealsys.pojo.OrderExample;
import zsc.ordermealsys.pojo.OrderItemWithBLOBs;
import zsc.ordermealsys.pojo.OrderPay;
import zsc.ordermealsys.pojo.OrderItem;
import zsc.ordermealsys.pojo.Product;
import zsc.ordermealsys.pojo.ProductWithBLOBs;
import zsc.ordermealsys.pojo.ShoppingCart;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.IOrderService;
import zsc.ordermealsys.util.BigDecimalUtil;
import zsc.ordermealsys.util.DateTimeUtil;
import zsc.ordermealsys.util.PropertiesUtil;

import zsc.ordermealsys.vo.OrderItemWithBLOBsVo;
import zsc.ordermealsys.vo.OrderProductVo;
import zsc.ordermealsys.vo.OrderVo;


@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {
	private static Log log = LogFactory.getLog(OrderServiceImpl.class);
	@Autowired
	OrderPayMapper orderPayMapper;

	@Autowired
	OrderMapper orderMapper;
	@Autowired
	OrderItemMapper orderItemMapper;
	ShoppingCartMapper shoppingCartMapper;
	ProductMapper productMapper;
	UserMapper userMapper;

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
	public ServerResponse pay(Long orderNo, Integer userId, String path) {
		// TODO Auto-generated method stub
		Map<String ,String> resultMap = Maps.newHashMap();
		System.out.print("调用之前userID是:"+userId);
		Order order = orderMapper.selectByUserIdAndOrderId(userId, orderNo);
		if(order == null){

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


		/*	 List<OrderItemWithBLOBs>	 orderItemList =orderItemMapper.getByOrderNoAndUserId(1L, 11);
	 for(OrderItemWithBLOBs orderItemWithBLOBs :orderItemList)
	 {
		 System.out.print(orderItemWithBLOBs.getPrice().toString()+"添加的"+orderItemWithBLOBs.getProductDetail()+"maij xingm ");

	 }
		 */
	}

	// 测试当面付2.0生成支付二维码
	public String test_trade_precreate(Order order,Integer userId,String path ) {
		String qrfilePath="";
		// (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
		// 需保证商户系统端不能重复，建议通过数据库sequence生成，
		String outTradeNo =order.getOrderNo().toString();

		// (必填) 订单标题，粗略描述用户的支付目的。如“xxx品牌xxx门店当面付扫码消费”
		String subject =new StringBuilder("订单编号:").append(order.getOrderNo()).toString();

		// (必填) 订单总金额，单位为元，不能超过1亿元
		// 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
		String totalAmount =order.getTotalPrice().toString();

		// (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
		// 如果该值未传入,但传入了【订单总金额】,【打折金额】,则该值默认为【订单总金额】-【打折金额】
		String undiscountableAmount = "0";

		// 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
		// 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
		String sellerId = "";

		// 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
		String body =new StringBuilder("订单编号:").append(order.getTotalPrice()).append("总计需要支付:").append(order.getTotalPrice()).append("元").toString();

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

		
		
		
		List<OrderItemWithBLOBs> orderItemList=new ArrayList<OrderItemWithBLOBs>();
		orderItemList=orderItemMapper.getByOrderNoAndUserId(order.getOrderNo(), userId);

		for(OrderItemWithBLOBs orderItem:orderItemList)
		{
			// 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
			GoodsDetail goods1 = GoodsDetail.newInstance(orderItem.getOrderNo().toString(), orderItem.getName(), BigDecimalUtil.mul(orderItem.getPrice().doubleValue(), new Double(100).doubleValue() ).longValue(), orderItem.getNum());
			// 创建好一个商品后添加至商品明细列表
			goodsDetailList.add(goods1);
		}




		/*  // 继续创建并添加第一条商品信息，用户购买的产品为“黑人牙刷”，单价为5.00元，购买了两件
	        GoodsDetail goods2 = GoodsDetail.newInstance("goods_id002", "xxx牙刷", 500, 2);
	        goodsDetailList.add(goods2);*/

		// 创建扫码支付请求builder，设置请求参数
		AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder()
				.setSubject(subject).setTotalAmount(totalAmount).setOutTradeNo(outTradeNo)
				.setUndiscountableAmount(undiscountableAmount).setSellerId(sellerId).setBody(body)
				.setOperatorId(operatorId).setStoreId(storeId).setExtendParams(extendParams)
//				.setTimeoutExpress(timeoutExpress).setNotifyUrl(PropertiesUtil.getProperty("alipay.callback.url"))//支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
				.setTimeoutExpress(timeoutExpress).setNotifyUrl("http://e458cr.natappfree.cc/ordermealsys/order/alipay_callback.do")//支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
				.setGoodsDetailList(goodsDetailList);


		//	        加载属性配置文件（从demo的main类的static块复制来的）
		/** 一定要在创建AlipayTradeService之前调用Configs.init()设置默认参数
		 *  Configs会读取classpath下的zfbinfo.properties文件配置信息，如果找不到该文件则确认该文件是否在classpath目录
		 */
		Configs.init("zfbinfo.properties");

		/** 使用Configs提供的默认参数
		 *  AlipayTradeService可以使用单例或者为静态成员对象，不需要反复new
		 */
		AlipayTradeService  tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();





		AlipayF2FPrecreateResult result = tradeService.tradePrecreate(builder);
		switch (result.getTradeStatus()) {
		case SUCCESS:
			log.info("支付宝预下单成功: )");
			AlipayTradePrecreateResponse response = result.getResponse();
			dumpResponse(response);
			//自己加的部分，集成特别重要的部分
			File folder=new File(path);
			if(!folder.exists())
			{
				folder.setWritable(true);
				folder.mkdirs();
			}

			// 需要修改为运行机器上的路径
			qrfilePath = String.format(path+"/qr-%s.png",response.getOutTradeNo());
			System.out.print("生成的二维码路径为:"+qrfilePath);


			ZxingUtils.getQRCodeImge(response.getQrCode(), 256, qrfilePath);



			//没有写把二维码上传到ftp服务器的代码，待完善
			
			log.info("filePath:" + qrfilePath);
			//                ZxingUtils.getQRCodeImge(response.getQrCode(), 256, filePath);
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
		qrfilePath=qrfilePath.substring(qrfilePath.lastIndexOf("\\")+1); 
		return  qrfilePath;
	}

	// 简单打印应答
	private void dumpResponse(AlipayResponse response) {
		if (response != null) {
			log.info(String.format("code:%s, msg:%s", response.getCode(), response.getMsg()));
			if (StringUtils.isNotEmpty(response.getSubCode())) {
				log.info(String.format("subCode:%s, subMsg:%s", response.getSubCode(),
						response.getSubMsg()));
			}
			log.info("body:" + response.getBody());
		}
	}










	//1.生成订单
	public  ServerResponse createOrder(Integer userId){
		
		System.out.println("未从购物车中获得数据");
		//从购物车中获取数据
		List<ShoppingCart> cartList = shoppingCartMapper.selectCheckedCartByUserId(userId);
		System.out.println("已从购物车中获得数据");

		//计算这个订单的总价
		ServerResponse serverResponse = this.getCartOrderItem(userId,cartList);
		if(!serverResponse.isSuccess()){
			return serverResponse;
		}
		List<OrderItemWithBLOBs> orderItemList = (List<OrderItemWithBLOBs>)serverResponse.getData();

		BigDecimal payment = this.getOrderTotalPrice(orderItemList);

		System.out.println("已计算出订单的总价");

		//生成订单
		Order order = this.assembleOrder(userId,payment,orderItemList);

		if(order == null){
			return ServerResponse.createByErrorMessage("生成订单错误");
		}
		if(CollectionUtils.isEmpty(orderItemList)){
			return ServerResponse.createByErrorMessage("购物车为空");
		}
		for(OrderItemWithBLOBs orderItem : orderItemList){
			orderItem.setOrderNo(order.getOrderNo());
		}
		System.out.println("生成订单成功");

		//mybatis 批量插入  orderItemList
		orderItemMapper.batchInsert(orderItemList);
		System.out.println("批量插入成功");

		//生成成功,我们要减少我们产品的库存
		this.reduceProductStock(orderItemList);
		System.out.println("成功扣除库存");

		//清空一下购物车
		this.cleanCart(cartList);
		System.out.println("清除购物车成功");

		//返回给前端数据
		OrderVo orderVo = assembleOrderVo(order,orderItemList);
		return ServerResponse.createBySuccess(orderVo);
	}

	//1.1获取购物车订单项
	private ServerResponse getCartOrderItem(Integer userId,List<ShoppingCart> cartList){
		List<OrderItemWithBLOBs> orderItemList = Lists.newArrayList();
		if(CollectionUtils.isEmpty(cartList)){
			return ServerResponse.createByErrorMessage("购物车为空");
		}
		System.out.println("购物车不为空");
		//校验购物车的数据,包括产品的状态和数量
		for(ShoppingCart cartItem : cartList){
			OrderItemWithBLOBs orderItemWithBLOBs=new OrderItemWithBLOBs();
			ProductWithBLOBs productWithBLOBs=productMapper.selectByPrimaryKey(cartItem.getProductId());
			System.out.println("已查找到商品");
			if(Const.ProductStatusEnum.ON_SALE.getCode() != productWithBLOBs.getProStatus()){
				System.out.println("商品不在售卖状态");
				return ServerResponse.createByErrorMessage("产品"+productWithBLOBs.getName()+"不是在线售卖状态");
			}
			//校验库存
			if(cartItem.getProductNum() > productWithBLOBs.getStock()){
				System.out.println("产品库存不足");
				return ServerResponse.createByErrorMessage("产品"+productWithBLOBs.getName()+"库存不足");
			}
			orderItemWithBLOBs.setUserId(userId);
			orderItemWithBLOBs.setProductId(productWithBLOBs.getId());
			orderItemWithBLOBs.setName(productWithBLOBs.getName());
			orderItemWithBLOBs.setProductPic(productWithBLOBs.getMainPic());
			orderItemWithBLOBs.setPrice(productWithBLOBs.getPrice());
			orderItemWithBLOBs.setNum(cartItem.getProductNum());
			orderItemList.add(orderItemWithBLOBs);
		}
		System.out.println("从购物车添加订单项目成功");
		return ServerResponse.createBySuccess(orderItemList);
	}

	//1.2获取订单项目总价的方法
	private BigDecimal getOrderTotalPrice(List<OrderItemWithBLOBs> orderItemList){
		BigDecimal payment=new BigDecimal("0");
		for(OrderItem orderItem:orderItemList){
			BigDecimal number=BigDecimal.valueOf(orderItem.getNum());
			BigDecimal totalPrice=BigDecimalUtil.mul(orderItem.getPrice().doubleValue(), number.doubleValue());
			payment=BigDecimalUtil.add(payment.doubleValue(),totalPrice.doubleValue());
		}
		return payment;
	}

	//1.3添加订单
	private Order assembleOrder(Integer userId,BigDecimal payment, List<OrderItemWithBLOBs> orderItemList){
		Order order=new Order();
		//		BigDecimal boxTotalPrice=this.BoxFee(orderItemList);
		long orderNo=this.generateOrderNo();
		order.setOrderNo(orderNo);
		order.setTotalPrice(payment);
		order.setCreateTime(new Date());
		order.setDeliveryType(0);
		order.setOrderType(null);
		order.setPayStatus(null);
		order.setOrderNotes("请尽快送达");
		order.setDeliveryTime(null);
		order.setOrderStatus(Const.OrderStatusEnum.NO_PAY.getCode());
		//		order.setBoxTotalPrice(boxTotalPrice);
		int rowCount=orderMapper.insert(order);
		if(rowCount>0){
			return order;
		}
		return null;
	}

	//1.4.减少商品库存量的方法
	private void reduceProductStock(List<OrderItemWithBLOBs> orderItemList){
		for(OrderItemWithBLOBs orderItem : orderItemList){
			ProductWithBLOBs product = productMapper.selectByPrimaryKey(orderItem.getProductId());
			product.setStock(product.getStock()-orderItem.getNum());
			productMapper.updateByPrimaryKeySelective(product);
		}
	}

	//1.5清空购物车的方法
	private void cleanCart(List<ShoppingCart> cartList){
		for(ShoppingCart cart : cartList){
			shoppingCartMapper.deleteByPrimaryKey(cart.getId());
		}
	}

	//1.6获取订单信息
	private OrderVo assembleOrderVo(Order order,List<OrderItemWithBLOBs> orderItemList){
		OrderVo orderVo = new OrderVo();
		orderVo.setSellerName(order.getSellerName());
		orderVo.setUserId(order.getUserId());
		orderVo.setOrderNo(order.getOrderNo());
		orderVo.setTotalPrice(order.getTotalPrice());
		orderVo.setCreateTime(DateTimeUtil.dateToStr(order.getCreateTime()));
		orderVo.setDeliveryType(order.getDeliveryType());
		orderVo.setOrderType(order.getOrderType());
		orderVo.setPayStatus(order.getPayStatus());
		orderVo.setOrderNotes(order.getOrderNotes());
		orderVo.setDeliveryTime(order.getDeliveryTime());
		orderVo.setDeleteStatus(order.getDeleteStatus());
		orderVo.setDeliveryFee(order.getDeliveryFee());
		orderVo.setOrderStatus(order.getOrderStatus());
		orderVo.setPayTime(DateTimeUtil.dateToStr(order.getPayTime()));
		orderVo.setTransactClosingTime(DateTimeUtil.dateToStr(order.getTransactClosingTime()));
		orderVo.setTransactCompleTime(DateTimeUtil.dateToStr(order.getTransactCompleTime()));
		orderVo.setUpdateTime(DateTimeUtil.dateToStr(order.getUpdateTime()));
		orderVo.setBoxTotalPrice(order.getBoxTotalPrice());
		orderVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));
		List<OrderItemWithBLOBsVo> orderItemVoList = Lists.newArrayList();
		for(OrderItemWithBLOBs orderItem : orderItemList){
			OrderItemWithBLOBsVo orderItemVo = assembleOrderItemVo(orderItem);
			orderItemVoList.add(orderItemVo);
		}
		orderVo.setOrderItemVoList(orderItemVoList);
		return orderVo;
	}

	//1.3.1生成订单流水号，运用了并发的原理
	private long generateOrderNo(){
		long currentTime=System.currentTimeMillis();
		return currentTime+new Random().nextInt(100);//随机生成0-9的数字加上前面的currentTime(并发)
	}

	//1.6.1获取订单项目的信息
	private OrderItemWithBLOBsVo assembleOrderItemVo(OrderItemWithBLOBs orderItem){
		OrderItemWithBLOBsVo orderItemVo = new OrderItemWithBLOBsVo();
		orderItemVo.setOrderNo(orderItem.getOrderNo());
		orderItemVo.setProductId(orderItem.getProductId());
		orderItemVo.setName(orderItem.getName());
		orderItemVo.setProductPic(orderItem.getProductPic());
		orderItemVo.setPrice(orderItem.getPrice());
		orderItemVo.setNum(orderItem.getNum());
		orderItemVo.setProductDetail(orderItem.getProductDetail());
		orderItemVo.setCreateTime(DateTimeUtil.dateToStr(orderItem.getCreateTime()));
		return orderItemVo;
	}

	//根据用户ID查询全部订单
	public ServerResponse<List<Order>> queryOrder(Integer userId){
		
		List<Order> OrderList=orderMapper.selectByUserId(userId);
		for(int i=0;i<OrderList.size();i++){
			Long orderNo=OrderList.get(i).getOrderNo();
			System.out.println(OrderList.get(i).getOrderNo().toString());

			List<OrderItemWithBLOBs> orderItemList=orderItemMapper.getByOrderNo(orderNo);
			
			OrderList.get(i).setOrderItem(orderItemList);
			for(int j=0;j<orderItemList.size();j++){
				System.out.println(OrderList.get(i).getOrderItem().get(j).getName().toString());
			}
		
		}
		
		
		return ServerResponse.createBySuccess(OrderList);
	}
	
	
	
	
	
	
	
	//3.获取餐盒总费用的方法
	//	public BigDecimal BoxFee(List<OrderItemWithBLOBs> orderItemList){
	//		BigDecimal BoxFee=new BigDecimal("0");
	//		for(OrderItem orderItem:orderItemList){
	//			Integer productId=orderItem.getProductId();
	//			Product product=productMapper.selectByPrimaryKey(productId);
	//			BigDecimal boxfee=product.getBoxFee();
	//			BigDecimal number=BigDecimal.valueOf(orderItem.getNum());
	//
	//			BigDecimal allboxfee=BigDecimalUtil.mul(boxfee.doubleValue(), number.doubleValue());
	//			BigDecimalUtil.add(BoxFee.doubleValue(),allboxfee.doubleValue());
	//		}
	//		return BoxFee;
	//	}


	//2.取消订单功能
	public ServerResponse<String> cancel(Integer userId,Long orderNo){
		Order order  = orderMapper.selectByUserIdAndOrderId(userId,orderNo);
		if(order == null){
			return ServerResponse.createByErrorMessage("该用户此订单不存在");
		}
		if(order.getPayStatus() != Const.OrderStatusEnum.NO_PAY.getCode()){
			return ServerResponse.createByErrorMessage("已付款,无法取消订单");
		}
		Order updateOrder = new Order();
		updateOrder.setId(order.getId());
		updateOrder.setOrderStatus(Const.OrderStatusEnum.CANCELED.getCode());

		int row = orderMapper.updateByPrimaryKeySelective(updateOrder);
		if(row > 0){
			return ServerResponse.createBySuccess();
		}
		return ServerResponse.createByError();
	}

	public ServerResponse getOrderCartProduct(Integer userId){
		OrderProductVo orderProductVo = new OrderProductVo();
		//从购物车中获取数据

		List<ShoppingCart> cartList = shoppingCartMapper.selectCheckedCartByUserId(userId);
		ServerResponse serverResponse =  this.getCartOrderItem(userId,cartList);
		if(!serverResponse.isSuccess()){
			return serverResponse;
		}
		
		List<OrderItemWithBLOBs> orderItemList =( List<OrderItemWithBLOBs> ) serverResponse.getData();

		List<OrderItemWithBLOBsVo> orderItemVoList = Lists.newArrayList();

		BigDecimal payment = new BigDecimal("0");
		for(OrderItemWithBLOBs orderItem : orderItemList){
			BigDecimal totalPrice=BigDecimalUtil.mul(orderItem.getNum().doubleValue(), orderItem.getPrice().doubleValue());
			payment = BigDecimalUtil.add(payment.doubleValue(),totalPrice.doubleValue());
			orderItemVoList.add(assembleOrderItemVo(orderItem));
		}
		orderProductVo.setProductTotalPrice(payment);
		orderProductVo.setOrderItemWithBLOBsList(orderItemVoList);
		orderProductVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));
		return ServerResponse.createBySuccess(orderProductVo);
	}

	//获取订单详情
	public ServerResponse<OrderVo> getOrderDetail(Integer userId,Long orderNo){
		Order order = orderMapper.selectByUserIdAndOrderId(userId, orderNo);
		if(order != null){
			List<OrderItemWithBLOBs> orderItemList = orderItemMapper.getByOrderNoAndUserId(orderNo,userId);
			OrderVo orderVo = assembleOrderVo(order,orderItemList);
			return ServerResponse.createBySuccess(orderVo);
		}
		return  ServerResponse.createByErrorMessage("没有找到该订单");
	}

	//获取订单列表
	public ServerResponse<PageInfo> getOrderList(Integer userId,int pageNum,int pageSize){
		PageHelper.startPage(pageNum,pageSize);
		List<Order> orderList = orderMapper.selectByUserId(userId);
		List<OrderVo> orderVoList = assembleOrderVoList(orderList,userId);
		PageInfo pageResult = new PageInfo(orderList);
		pageResult.setList(orderVoList);
		return ServerResponse.createBySuccess(pageResult);
	}

	
	private List<OrderVo> assembleOrderVoList(List<Order> orderList,Integer userId){
		List<OrderVo> orderVoList = Lists.newArrayList();
		for(Order order : orderList){
			List<OrderItemWithBLOBs>  orderItemList = Lists.newArrayList();
			if(userId == null){
				//todo 管理员查询的时候 不需要传userId
				orderItemList = orderItemMapper.getByOrderNo(order.getOrderNo());
			}else{
				orderItemList = orderItemMapper.getByOrderNoAndUserId(order.getOrderNo(),userId);
			}
			OrderVo orderVo = assembleOrderVo(order,orderItemList);
			orderVoList.add(orderVo);
		}
		return orderVoList;
	}

	
	
	//backend

    public ServerResponse<PageInfo> manageList(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orderList = orderMapper.selectAllOrder();
        List<OrderVo> orderVoList = this.assembleOrderVoList(orderList,null);
        PageInfo pageResult = new PageInfo(orderList);
        pageResult.setList(orderVoList);
        return ServerResponse.createBySuccess(pageResult);
    }


    public ServerResponse<OrderVo> manageDetail(Long orderNo){
        Order order = orderMapper.selectByOrderNo(orderNo);
        if(order != null){
            List<OrderItemWithBLOBs> orderItemList = orderItemMapper.getByOrderNo(orderNo);
            OrderVo orderVo = assembleOrderVo(order,orderItemList);
            return ServerResponse.createBySuccess(orderVo);
        }
        return ServerResponse.createByErrorMessage("订单不存在");
    }



    public ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Order order = orderMapper.selectByOrderNo(orderNo);
        if(order != null){
            List<OrderItemWithBLOBs> orderItemList = orderItemMapper.getByOrderNo(orderNo);
            OrderVo orderVo = assembleOrderVo(order,orderItemList);

            PageInfo pageResult = new PageInfo(Lists.newArrayList(order));
            pageResult.setList(Lists.newArrayList(orderVo));
            return ServerResponse.createBySuccess(pageResult);
        }
        return ServerResponse.createByErrorMessage("订单不存在");
    }


    public ServerResponse<String> manageSendGoods(Long orderNo){
        Order order= orderMapper.selectByOrderNo(orderNo);
        if(order != null){
            if(order.getOrderStatus() == Const.OrderStatusEnum.PAID.getCode()){
                order.setOrderStatus(Const.OrderStatusEnum.SHIPPED.getCode());
                order.setDeliveryTime(new Date().toString());
                orderMapper.updateByPrimaryKeySelective(order);
                return ServerResponse.createBySuccess("发货成功");
            }
        }
        return ServerResponse.createByErrorMessage("订单不存在");
    }





































	/*
	 * List<OrderItemWithBLOBs> orderItemList
	 * =orderItemMapper.getByOrderNoAndUserId(1L, 11);
	 * for(OrderItemWithBLOBs orderItemWithBLOBs :orderItemList) {
	 * System.out.print(orderItemWithBLOBs.getPrice().toString()+"添加的"+
	 * orderItemWithBLOBs.getProductDetail()+"maij xingm ");
	 * 
	 * }
	 */


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
	/*	public String test_trade_precreate(Order order, Integer userId, String path) {
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


	 * // 继续创建并添加第一条商品信息，用户购买的产品为“黑人牙刷”，单价为5.00元，购买了两件 GoodsDetail goods2 =
	 * GoodsDetail.newInstance("goods_id002", "xxx牙刷", 500, 2);
	 * goodsDetailList.add(goods2);


		// 创建扫码支付请求builder，设置请求参数
		AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder().setSubject(subject)
				.setTotalAmount(totalAmount).setOutTradeNo(outTradeNo).setUndiscountableAmount(undiscountableAmount)
				.setSellerId(sellerId).setBody(body).setOperatorId(operatorId).setStoreId(storeId)
				.setExtendParams(extendParams).setTimeoutExpress(timeoutExpress)
				.setNotifyUrl(PropertiesUtil.getProperty("alipay.callback.url"))// 支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
				.setGoodsDetailList(goodsDetailList);

		// 加载属性配置文件（从demo的main类的static块复制来的）
	 *//**
	 * 一定要在创建AlipayTradeService之前调用Configs.init()设置默认参数
	 * Configs会读取classpath下的zfbinfo.properties文件配置信息，
	 * 如果找不到该文件则确认该文件是否在classpath目录
	 *//*
		Configs.init("zfbinfo.properties");

	  *//**
	  * 使用Configs提供的默认参数 AlipayTradeService可以使用单例或者为静态成员对象，不需要反复new
	  *//*
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
	   */
	
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
