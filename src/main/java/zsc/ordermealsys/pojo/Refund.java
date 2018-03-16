package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Refund {
    private Integer id;

    private Integer orderId;

    private Integer status;

    private Integer type;

    private String reason;

    private BigDecimal money;

    private String explain;

    private Date createTime;

    private Date updateTime;

    public Refund(Integer id, Integer orderId, Integer status, Integer type, String reason, BigDecimal money, String explain, Date createTime, Date updateTime) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.type = type;
        this.reason = reason;
        this.money = money;
        this.explain = explain;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Refund() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
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