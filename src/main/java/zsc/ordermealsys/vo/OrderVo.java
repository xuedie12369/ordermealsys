package zsc.ordermealsys.vo;

import java.math.BigDecimal;
import java.util.List;

import zsc.ordermealsys.pojo.Address;

public class OrderVo {

	private String sellerName;
    
    private Integer userId;
    
    private Long orderNo;
    
    private BigDecimal totalPrice;

    private String createTime;

    private Integer addressId;
    
    private String address;

    private Integer orderType;

    private Integer payStatus;

    private String orderNotes;

    private String deliveryTime;

    private Integer deleteStatus;

    private BigDecimal deliveryFee;

    private Integer orderStatus;

    private String payTime;

    private String transactClosingTime;

    private String transactCompleTime;

    private String updateTime;

    private BigDecimal boxTotalPrice;
    
    //订单明细
    private List<OrderItemWithBLOBsVo>orderItemVoList;
    
    private String imageHost;
    
    private Integer shippingId;
    
    private String consigneeName;

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getOrderNotes() {
		return orderNotes;
	}

	public void setOrderNotes(String orderNotes) {
		this.orderNotes = orderNotes;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getTransactClosingTime() {
		return transactClosingTime;
	}

	public void setTransactClosingTime(String transactClosingTime) {
		this.transactClosingTime = transactClosingTime;
	}

	public String getTransactCompleTime() {
		return transactCompleTime;
	}

	public void setTransactCompleTime(String transactCompleTime) {
		this.transactCompleTime = transactCompleTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public BigDecimal getBoxTotalPrice() {
		return boxTotalPrice;
	}

	public void setBoxTotalPrice(BigDecimal boxTotalPrice) {
		this.boxTotalPrice = boxTotalPrice;
	}

	public List<OrderItemWithBLOBsVo> getOrderItemVoList() {
		return orderItemVoList;
	}

	public void setOrderItemVoList(List<OrderItemWithBLOBsVo> orderItemVoList) {
		this.orderItemVoList = orderItemVoList;
	}

	public String getImageHost() {
		return imageHost;
	}

	public void setImageHost(String imageHost) {
		this.imageHost = imageHost;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    
    
}
