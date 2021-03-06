package zsc.ordermealsys.pojo;

import java.math.BigDecimal;

public class Order_ItemWithBLOBs extends Order_Item {
    private String productPic;

    private String productDetail;

    public Order_ItemWithBLOBs(Integer id, String orderId, String productId, String buyerName, String sellerName, BigDecimal price, Integer num, String productPic, String productDetail) {
        super(id, orderId, productId, buyerName, sellerName, price, num);
        this.productPic = productPic;
        this.productDetail = productDetail;
    }

    public Order_ItemWithBLOBs() {
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