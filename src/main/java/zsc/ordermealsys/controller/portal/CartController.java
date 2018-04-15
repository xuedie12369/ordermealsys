package zsc.ordermealsys.controller.portal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.User;
import zsc.ordermealsys.service.ICartService;
import zsc.ordermealsys.vo.ShoppingCartVo;

@Controller
@RequestMapping("/cart/")
public class CartController {

	@Autowired
	private ICartService iCartService;
	
	
	@RequestMapping("list.do")
	@ResponseBody
	public ServerResponse<ShoppingCartVo> list(HttpSession session){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		System.out.print("当前登录的用户ID是:"+user.getId());
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.list(user.getId());
	}

	//往购物车中添加商品的功能
	@RequestMapping("add.do")
	@ResponseBody
	public ServerResponse<ShoppingCartVo> add(HttpSession session, Integer count,Integer productId){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		
		System.out.print(count+"数量"+"产品的ID是:"+productId);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.add(user.getId(), productId, count);
	}

	//更新购物车中商品数据的功能
	@RequestMapping("update.do")
	@ResponseBody
	public ServerResponse<ShoppingCartVo> update(HttpSession session, Integer count,Integer productId){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.update(user.getId(), productId, count);
	}

	//删除购物车中的商品
	@RequestMapping("delete_product.do")
	@ResponseBody
	public ServerResponse<ShoppingCartVo> deleteProduct(HttpSession session, String productIds){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.deleteProduct(user.getId(), productIds);
	}

	//全选
	@RequestMapping("select_all.do")
	@ResponseBody
	public ServerResponse<ShoppingCartVo> selectAll(HttpSession session){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.selectOrUnSelect(user.getId(), null, Const.ShoppingCart.CHECKED);
	}

	//全反选
	@RequestMapping("un_select_all.do")
	@ResponseBody
	public ServerResponse<ShoppingCartVo> unSelectAll(HttpSession session){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.selectOrUnSelect(user.getId(), null, Const.ShoppingCart.UN_CHECKED);
	}

	//单独选
	@RequestMapping("select.do")
	@ResponseBody
	public ServerResponse<ShoppingCartVo> select(HttpSession session, Integer productId){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.selectOrUnSelect(user.getId(), productId, Const.ShoppingCart.UN_CHECKED);
	}

	//单独反选
	@RequestMapping("un_select.do")
	@ResponseBody
	public ServerResponse<ShoppingCartVo> unSelect(HttpSession session, Integer productId){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), 
					ResponseCode.NEED_LOGIN.getDesc());
		}
		return iCartService.selectOrUnSelect(user.getId(), productId, Const.ShoppingCart.UN_CHECKED);
	}

	//查询当前用户的购物车里面的产品数量，如果一个产品有10个，那么数量就是10
	@RequestMapping("get_cart_product_count.do")
	@ResponseBody
	public ServerResponse<Integer> getCartProductCount(HttpSession session){
		User user=(User)session.getAttribute(Const.CURRENT_USER);
		if(user==null){
			return ServerResponse.createBySuccess(0);
		}
		return iCartService.getCartProductCount(user.getId());
	}

}
