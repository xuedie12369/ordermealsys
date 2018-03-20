package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer id;

    private String sellerName;

    private String name;


    private BigDecimal price;

    private Integer stock;

    private Integer sales;

    private Integer proStatus;

    private Integer delStatus;

    private Date createTime;

    private Date updateTime;

    private BigDecimal deliveryFee;

    private BigDecimal boxFee;

    private BigDecimal boxPrice;

    public Product(Integer id, String sellerName, String name,BigDecimal price, Integer stock, Integer sales, Integer proStatus, Integer delStatus, Date createTime, Date updateTime, BigDecimal deliveryFee, BigDecimal boxFee, BigDecimal boxPrice) {
        this.id = id;
        this.sellerName = sellerName;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.proStatus = proStatus;
        this.delStatus = delStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deliveryFee = deliveryFee;
        this.boxFee = boxFee;
        this.boxPrice = boxPrice;
    }

    public Product() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getProStatus() {
        return proStatus;
    }

    public void setProStatus(Integer proStatus) {
        this.proStatus = proStatus;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
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

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BigDecimal getBoxFee() {
        return boxFee;
    }

    public void setBoxFee(BigDecimal boxFee) {
        this.boxFee = boxFee;
    }

    public BigDecimal getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(BigDecimal boxPrice) {
        this.boxPrice = boxPrice;
    }
}