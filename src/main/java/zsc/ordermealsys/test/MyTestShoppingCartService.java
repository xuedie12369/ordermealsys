package zsc.ordermealsys.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zsc.ordermealsys.dao.AddressMapper;
import zsc.ordermealsys.dao.ShoppingCartMapper;
import zsc.ordermealsys.pojo.Address;
import zsc.ordermealsys.service.IShippingService;
import zsc.ordermealsys.service.impl.CartServiceImpl;


public class MyTestShoppingCartService {
	
	@Resource
	AddressMapper addressMapper;
	/*public ShoppingCartMapper getShoppingMapperDao(){
		return cartMapper;
	}	
	public void ShoppingMapperDao(ShoppingCartMapper cartMapper) {
		this.cartMapper = cartMapper;
	} */
	
	public AddressMapper getShoppingMapperDao(){
		return addressMapper;
	}	
	public void AddressMapperDao(AddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	} 
	
	@Test
	public void main(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//CartServiceImpl iCartService=ac.getBean(CartServiceImpl.class);
		/*iCartService.add(1, 1, 5);
		iCartService.list(1);
		iCartService.update(1, 1, 5);*/
		//iCartService.deleteProduct(1, "1");
		IShippingService iShippingService=ac.getBean(IShippingService.class);
		Address ad=new Address();
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
