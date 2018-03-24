package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private String sellerName;
    private Integer userId;
    private Long orderNo;
    public Order(Integer id, String sellerName, Integer userId, Long orderNo, BigDecimal totalPrice, Date createTime,
			Integer deliveryType, Integer orderType, Integer payStatus, String orderNotes, String deliveryTime,
			Integer deleteStatus, BigDecimal deliveryFee, Integer orderStatus, Date payTime, Date transactClosingTime,
			Date transactCompleTime, Date updateTime, BigDecimal boxTotalPrice) {
		super();
		this.id = id;
		this.sellerName = sellerName;
		this.userId = userId;
		this.orderNo = orderNo;
		this.totalPrice = totalPrice;
		this.createTime = createTime;
		this.deliveryType = deliveryType;
		this.orderType = orderType;
		this.payStatus = payStatus;
		this.orderNotes = orderNotes;
		this.deliveryTime = deliveryTime;
		this.deleteStatus = deleteStatus;
		this.deliveryFee = deliveryFee;
		this.orderStatus = orderStatus;
		this.payTime = payTime;
		this.transactClosingTime = transactClosingTime;
		this.transactCompleTime = transactCompleTime;
		this.updateTime = updateTime;
		this.boxTotalPrice = boxTotalPrice;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	
	
	public Integer getuserId() {
		return userId;
	}

	public void setuserId(Integer userId) {
		this.userId = userId;
	}

	private BigDecimal totalPrice;

    private Date createTime;

    private Integer deliveryType;

    private Integer orderType;

    private Integer payStatus;

    private String orderNotes;

    private String deliveryTime;

    private Integer deleteStatus;

    private BigDecimal deliveryFee;

    private Integer orderStatus;

    private Date payTime;

    private Date transactClosingTime;

    private Date transactCompleTime;

    private Date updateTime;

    private BigDecimal boxTotalPrice;

   
    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
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
        this.orderNotes = orderNotes == null ? null : orderNotes.trim();
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getTransactClosingTime() {
        return transactClosingTime;
    }

    public void setTransactClosingTime(Date transactClosingTime) {
        this.transactClosingTime = transactClosingTime;
    }

    public Date getTransactCompleTime() {
        return transactCompleTime;
    }

    public void setTransactCompleTime(Date transactCompleTime) {
        this.transactCompleTime = transactCompleTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getBoxTotalPrice() {
        return boxTotalPrice;
    }

    public void setBoxTotalPrice(BigDecimal boxTotalPrice) {
        this.boxTotalPrice = boxTotalPrice;
    }
}