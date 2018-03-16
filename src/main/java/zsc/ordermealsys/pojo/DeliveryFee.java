package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class DeliveryFee {
    private Integer id;

    private String sellerName;

    private Integer range;

    private BigDecimal price;

    private Date createTime;

    private Date updateTime;

    public DeliveryFee(Integer id, String sellerName, Integer range, BigDecimal price, Date createTime, Date updateTime) {
        this.id = id;
        this.sellerName = sellerName;
        this.range = range;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public DeliveryFee() {
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

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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