package zsc.ordermealsys.pojo;

import java.util.Date;

public class OrderPay {
    private Integer id;

    private Long orderNo;

    private Integer userId;

    private Integer thirdPartyUsername;

    private Long serialNumber;

    private Integer payPlatformName;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    public OrderPay(Integer id, Long orderNo, Integer userId, Integer thirdPartyUsername, Long serialNumber, Integer payPlatformName, Integer payStatus, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.userId = userId;
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

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getThirdPartyUsername() {
        return thirdPartyUsername;
    }

    public void setThirdPartyUsername(Integer thirdPartyUsername) {
        this.thirdPartyUsername = thirdPartyUsername;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getPayPlatformName() {
        return payPlatformName;
    }

    public void setPayPlatformName(Integer payPlatformName) {
        this.payPlatformName = payPlatformName;
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