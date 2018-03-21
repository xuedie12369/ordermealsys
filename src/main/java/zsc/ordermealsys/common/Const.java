package zsc.ordermealsys.common;

public class Const {
	public static final String CURRENT_USER="currentUser";
	
	public static final String EMAIL="email";
	public static final String USERNAME="username";
	public interface Role{
		int ROLE_CUSTOMER=0;	//普通用户
		int ROLE_ADMIN=1;   	//管理员用户
	}
	public interface ShoppingCart{
		int CHECKED=1;//即购物车选中状态
		int UN_CHECKED=0;//即购物车未被选中状态
		
		String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
	}
/*	
	public interface Type{
		int Type_CUSTOMER=0;	//普通用户
		int Type_ADMIN=1;   	//管理员用户
>>>>>>> hjs-master*/
	
}
