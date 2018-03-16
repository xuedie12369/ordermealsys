package zsc.ordermealsys.pojo;

import java.util.Date;

public class OrderStatus {
    private Integer id;

    private String orderId;

    private Integer orderStatus;

    private Date createTime;

    private Date updateTime;

    public OrderStatus(Integer id, String orderId, Integer orderStatus, Date createTime, Date updateTime) {
        this.id = id;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderStatus() {
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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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