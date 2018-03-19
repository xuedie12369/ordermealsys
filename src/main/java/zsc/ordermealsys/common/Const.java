package zsc.ordermealsys.common;

public class Const {
	public static final String CURRENT_USER="currentUser";
	
	public static final String EMAIL="email";
	public static final String USERNAME="username";
	
	public interface shoppingCart{
		int CHECKED=1;//即购物车选中状态
		int UN_CHECKED=0;//即购物车未被选中状态
	}
	
	public interface Type{
		int Type_CUSTOMER=0;	//普通用户
		int Type_ADMIN=1;   	//管理员用户
	}
}
