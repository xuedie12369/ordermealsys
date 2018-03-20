package zsc.ordermealsys.test;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTestTest {
	//测试浮点数丢失精度的错误
	/*@Test
	public void test1(){
		System.out.println(0.05+0.01);//0.06    与测试结果0.060000000000000005不同，将会导致用户余额有0.06却无法购买商品
		System.out.println(1.0-0.42);//0.58
		System.out.println(4.015*100);//401.5
		System.out.println(123.3/100);//1.233
	}*/
	
	/*@Test
	public void test2(){
		BigDecimal b1=new BigDecimal(0.05);
		BigDecimal b2=new BigDecimal(0.01);
		System.out.println(b1.add(b2));
	}*/
	
	//BigDecimal
	@Test
	public void test3(){
		BigDecimal b1=new BigDecimal("0.05");//使用字符串参数构造器可以避免出现丢失精度的问题
		BigDecimal b2=new BigDecimal("0.01");
		System.out.println(b1.add(b2));
	}
	
	
}
