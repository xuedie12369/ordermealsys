package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItemWithBLOBs extends OrderItem {
    private String productPic;

    private String productDetail;

    public OrderItemWithBLOBs(Integer id, String orderId, String productId, String buyerName, String sellerName, BigDecimal price, Integer num, Date createTime, Date updateTime, String productPic, String productDetail) {
        super(id, orderId, productId, buyerName, sellerName, price, num, createTime, updateTime);
        this.productPic = productPic;
        this.productDetail = productDetail;
    }

    public OrderItemWithBLOBs() {
        super();
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic == null ? null : productPic.trim();
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail == null ? null : productDetail.trim();
    }
}