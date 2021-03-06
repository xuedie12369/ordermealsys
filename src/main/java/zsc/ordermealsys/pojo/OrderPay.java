package zsc.ordermealsys.pojo;

import java.util.Date;

public class OrderPay {
    private Integer id;

    private String orderId;

    private String buyerName;

    private String sellerName;

    private String thirdPartyUsername;

    private String serialNumber;

    private String payPlatformName;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    public OrderPay(Integer id, String orderId, String buyerName, String sellerName, String thirdPartyUsername, String serialNumber, String payPlatformName, Integer payStatus, Date createTime, Date updateTime) {
        this.id = id;
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
        this.thirdPartyUsername = thirdPartyUsername;
        this.serialNumber = serialNumber;
        this.payPlatformName = payPlatformName;
        this.payStatus = payStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderPay() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    public String getThirdPartyUsername() {
        return thirdPartyUsername;
    }

    public void setThirdPartyUsername(String thirdPartyUsername) {
        this.thirdPartyUsername = thirdPartyUsername == null ? null : thirdPartyUsername.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getPayPlatformName() {
        return payPlatformName;
    }

    public void setPayPlatformName(String payPlatformName) {
        this.payPlatformName = payPlatformName == null ? null : payPlatformName.trim();
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}