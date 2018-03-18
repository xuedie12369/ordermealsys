package zsc.ordermealsys.common;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

//保证序列化Json的时候，如果是null的对象，key也会消失
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {
	private int status;
	private String msg;
	private T data;
	
	private ServerResponse(int status){
		this.status=status;
	}
	
	private ServerResponse(int status,String msg){
		this.status=status;
		this.msg=msg;
	}
	
	private ServerResponse(int status,T data){
		this.status=status;
		this.data=data;
	}
	
	private ServerResponse(int status,String msg,T data){
		this.status=status;
		this.msg=msg;
		this.data=data;
	}
	
	@JsonIgnore//使之不在json序列化结果当中
	//响应是否成功
	public boolean isSuccess(){
		return this.status==ResponseCode.SUCCESS.getCode();
	}
	//获取用户状态
	public int getStatus(){
		return status;
	}
	//获取用户数据
	public T getData(){
		return data;
	}
	//获取用户消息
	public String getMsg(){
		return msg;
	}
	//对外提供的获取登录信息的方法
	public static <T> ServerResponse<T> createBySuccess(){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}
	//获取msg的方法
	public static <T> ServerResponse<T> createBySuccessMessage(String msg){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
	}
	//获取data的方法
	public static <T> ServerResponse<T> createBySuccessMessage(T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
	}
	//获取msg和data的方法
	public static <T> ServerResponse<T> createBySuccessMessage(String msg,T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
	}
	
	//获取登录信息失败信息的方法
	public static <T> ServerResponse<T> createByError(){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),
				ResponseCode.ERROR.getDesc());
	}
	
	//提示信息
	public static <T>ServerResponse<T> createByErrorMessage(String errorMessage){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
	}
	
	
	public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
		return new ServerResponse<T>(errorCode,errorMessage);
	}
}
