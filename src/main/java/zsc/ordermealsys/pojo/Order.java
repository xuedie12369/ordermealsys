package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order {
 private List<OrderItemWithBLOBs> orderItem;
	public List<OrderItemWithBLOBs> getOrderItem() {
	return orderItem;
}

public void setOrderItem(List<OrderItemWithBLOBs> orderItem) {
	this.orderItem = orderItem;
}

	private Integer id;

    private Integer shopId;

    private Integer userId;
    
    private Long orderNo;

    private BigDecimal totalPrice;

    private Date createTime;

    private Integer deliveryType;

    private Integer payStatus;

    private String orderNotes;

    private String deliveryTime;

    private Integer deleteStatus;

    private BigDecimal deliveryFee;

    private Date payTime;

    private Date updateTime;

    private BigDecimal boxTotalPrice;

    private String detaiAdd;

    private String tel;

    private Integer sex;

    private String consigneeName;

    public Order(Integer id, Integer shopId, Integer userId, Long orderNo, BigDecimal totalPrice, Date createTime, Integer deliveryType, Integer payStatus, String orderNotes, String deliveryTime, Integer deleteStatus, BigDecimal deliveryFee, Date payTime, Date updateTime, BigDecimal boxTotalPrice, String detaiAdd, String tel, Integer sex, String consigneeName) {
        this.id = id;
        this.shopId = shopId;
        this.userId = userId;
        this.orderNo = orderNo;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
        this.deliveryType = deliveryType;
        this.payStatus = payStatus;
        this.orderNotes = orderNotes;
        this.deliveryTime = deliveryTime;
        this.deleteStatus = deleteStatus;
        this.deliveryFee = deliveryFee;
        this.payTime = payTime;
        this.updateTime = updateTime;
        this.boxTotalPrice = boxTotalPrice;
        this.detaiAdd = detaiAdd;
        this.tel = tel;
        this.sex = sex;
        this.consigneeName = consigneeName;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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

    public String getDetaiAdd() {
        return detaiAdd;
    }

    public void setDetaiAdd(String detaiAdd) {
        this.detaiAdd = detaiAdd == null ? null : detaiAdd.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName == null ? null : consigneeName.trim();
    }
}