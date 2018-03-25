package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
    private Integer id;

    private Long orderNo;

    private String productId;

    private Integer userId;

    private String sellerName;

    private BigDecimal price;

    private Integer num;

    private Date createTime;

    private Date updateTime;

    public OrderItem(Integer id, Long orderNo, String productId, Integer userId, String sellerName, BigDecimal price, Integer num, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.productId = productId;
        this.userId = userId;
        this.sellerName = sellerName;
        this.price = price;
        this.num = num;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getorderNo() {
        return orderNo;
    }

    public void setorderNo(Long orderNo) {
        this.orderNo = orderNo == null ? null : orderNo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Integer getuserId() {
        return userId;
    }

    public void setuserId(Integer userId) {
        this.userId = userId == null ? null : userId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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