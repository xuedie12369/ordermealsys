package zsc.ordermealsys.vo;

import java.math.BigDecimal;
import java.util.List;

public class OrderProductVo {
	private List<OrderItemWithBLOBsVo> orderItemWithBLOBsList;
	private BigDecimal productTotalPrice;
	private String imageHost;
	
	public List<OrderItemWithBLOBsVo> getOrderItemWithBLOBsList() {
		return orderItemWithBLOBsList;
	}
	public void setOrderItemWithBLOBsList(List<OrderItemWithBLOBsVo> orderItemWithBLOBsList) {
		this.orderItemWithBLOBsList = orderItemWithBLOBsList;
	}
	public BigDecimal getProductTotalPrice() {
		return productTotalPrice;
	}
	public void setProductTotalPrice(BigDecimal productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}
	public String getImageHost() {
		return imageHost;
	}
	public void setImageHost(String imageHost) {
		this.imageHost = imageHost;
	}
}
