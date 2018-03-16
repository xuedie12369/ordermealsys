package zsc.ordermealsys.pojo;

import java.math.BigDecimal;

public class Order_Item {
    private Integer id;

    private String orderId;

    private String productId;

    private String buyerName;

    private String sellerName;

    private BigDecimal price;

    private Integer num;

    public Order_Item(Integer id, String orderId, String productId, String buyerName, String sellerName, BigDecimal price, Integer num) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
        this.price = price;
        this.num = num;
    }

    public Order_Item() {
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
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
}