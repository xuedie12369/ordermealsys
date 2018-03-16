package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingCart {
    private Integer id;

    private String buyerName;

    private String sellerName;

    private Integer productId;

    private BigDecimal productPrice;

    private Integer productNum;

    private Date createTime;

    private Date updateTime;

    public ShoppingCart(Integer id, String buyerName, String sellerName, Integer productId, BigDecimal productPrice, Integer productNum, Date createTime, Date updateTime) {
        this.id = id;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productNum = productNum;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ShoppingCart() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
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