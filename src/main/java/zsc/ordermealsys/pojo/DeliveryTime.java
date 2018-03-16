package zsc.ordermealsys.pojo;

import java.util.Date;

public class DeliveryTime {
    private Integer id;

    private String sellerName;

    private String deliveryTime;

    private Date createTime;

    private Date updateTime;

    public DeliveryTime(Integer id, String sellerName, String deliveryTime, Date createTime, Date updateTime) {
        this.id = id;
        this.sellerName = sellerName;
        this.deliveryTime = deliveryTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public DeliveryTime() {
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

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
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