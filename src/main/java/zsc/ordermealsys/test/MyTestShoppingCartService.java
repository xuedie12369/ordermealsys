package zsc.ordermealsys.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zsc.ordermealsys.controller.portal.CartController;
import zsc.ordermealsys.dao.AddressMapper;
import zsc.ordermealsys.dao.OrderItemMapper;
import zsc.ordermealsys.dao.OrderMapper;
import zsc.ordermealsys.dao.ShoppingCartMapper;
import zsc.ordermealsys.pojo.Address;
import zsc.ordermealsys.service.ICartService;
import zsc.ordermealsys.service.IOrderService;
import zsc.ordermealsys.service.IShippingService;
import zsc.ordermealsys.service.impl.CartServiceImpl;
import zsc.ordermealsys.service.impl.OrderServiceImpl;
import zsc.ordermealsys.service.impl.ShippingServiceImpl;


public class MyTestShoppingCartService {
	
//	@Resource
//	AddressMapper addressMapper;
	@Resource
	ShoppingCartMapper cartMapper;
//	@Resource
//	OrderMapper orderMapper;
	@Resource
//	AddressMapper addressMapper;

//	OrderMapper orderMapper;
//	OrderItemMapper orderItemMapper;
//	
//	public OrderMapper getOrderMapperDao(){
//		return orderMapper;
//	}
//	
//	public OrderItemMapper getOrderItemMapperDao(){
//		return orderItemMapper;
//	}
//	
//	public void OrderMapperDao(OrderMapper orderMapper){
//		this.orderMapper=orderMapper;
//	}
//	
//	public void OrderItemMapperDao(OrderItemMapper orderItemMapper){
//		this.orderItemMapper=orderItemMapper;
//	}
	
	public ShoppingCartMapper getShoppingMapperDao(){
		return cartMapper;
	}	
	public void ShoppingMapperDao(ShoppingCartMapper cartMapper) {
		this.cartMapper = cartMapper;
	} 
	
//	public OrderMapper getOrderMapperDao(){
//		return orderMapper;
//	}
//	public void OrderMapperDao(OrderMapper orderMapper){
//		this.orderMapper=orderMapper;
//	}
	
//	public AddressMapper getAddressMapperDao(){
//		return addressMapper;
//	}
//	public void AddressMapperDao(AddressMapper addressMapper){
//		this.addressMapper=addressMapper;
//	}
	
//	public AddressMapper getShoppingMapperDao(){
//		return addressMapper;
//	}	
//	public void AddressMapperDao(AddressMapper addressMapper) {
//		this.addressMapper = addressMapper;
//	} 
	
	@Test
	public void main(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		OrderServiceImpl iOrderService=ac.getBean(OrderServiceImpl.class);
//		OrderItemMapper orderMapper=ac.getBean(OrderItemMapper.class);
//		ShippingServiceImpl iShippingService=ac.getBean(ShippingServiceImpl.class);
		CartServiceImpl iCartServiceImpl=ac.getBean(CartServiceImpl.class);
//		ShoppingCartMapper shoppingCartMapper=(ShoppingCartMapper) ac.getBean("shoppingCartMapper");
//		shoppingCartMapper.selectCartByUserId(1);
//		System.out.print(	shoppingCartMapper.selectCartByUserId(1));
		iCartServiceImpl.add(1, 2, 100);
//		iCartServiceImpl.deleteProduct(1, 2);
		
//		orderMapper.getByOrderNo((long) 47);
//		iOrderService.queryOrder(1);
//		iOrderService.createOrder(1);
//		iShippingService.selectAllAddressByUserId(1);
//		IOrderService iOrderService=ac.getBean(IOrderService.class);
//		iOrderService.createOrder(1);
//		ICartService iCartService=ac.getBean(ICartService.class);
//		iCartService.add(1, 1, 5);
//		iCartService.list(1);
//		iCartService.update(1, 1, 5);
//		iCartService.deleteProduct(1, "1");
//		IShippingService iShippingService=ac.getBean(IShippingService.class);
//		Address ad=new Address();
		/*ad.setConsigneeName("黄俊淞");
		ad.setSex(1);
		ad.setTel("18718005465");
		ad.setNation("中国");
		ad.setProvince("广东省");
		ad.setCity("中山市");
		ad.setCounty("石岐区");
		ad.setTown("厚兴");
		ad.setDetailedAdd("电子科技大学中山学院");
		ad.setPostCode("1101");*/
		
//		ad.setId(6);
//		ad.setConsigneeName("邵海楠");
//		ad.setSex(1);
//		ad.setTel("18718005465");
//		ad.setNation("中国");
//		ad.setProvince("江苏省");
//		ad.setCity("徐州市");
//		ad.setCounty("丰县");
//		ad.setTown("凤城镇");
//		ad.setDetailedAdd("西关村");
//		ad.setPostCode("1101");
		
//		iShippingService.add(1, ad);
		/*iShippingService.del(1, 2);*/
//		iShippingService.update(1,ad);
//		iShippingService.select(1, 6);
	}
}
