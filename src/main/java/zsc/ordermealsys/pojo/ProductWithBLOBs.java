package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ProductWithBLOBs extends Product {
    private String mainPic;

    private String subPic1;

    private String subPic2;

    private String subPic3;

    private String detail;

    public ProductWithBLOBs(Integer id, String sellerName, String name, BigDecimal price, Integer stock, Integer sales, Integer proStatus, Integer delStatus, Date createTime, Date updateTime, BigDecimal deliveryFee, BigDecimal boxFee, BigDecimal boxPrice, String mainPic, String subPic1, String subPic2, String subPic3, String detail) {
        super(id, sellerName, name, price, stock, sales, proStatus, delStatus, createTime, updateTime, deliveryFee, boxFee, boxPrice);
        this.mainPic = mainPic;
        this.subPic1 = subPic1;
        this.subPic2 = subPic2;
        this.subPic3 = subPic3;
        this.detail = detail;
    }

    public ProductWithBLOBs() {
        super();
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic == null ? null : mainPic.trim();
    }

    public String getSubPic1() {
        return subPic1;
    }

    public void setSubPic1(String subPic1) {
        this.subPic1 = subPic1 == null ? null : subPic1.trim();
    }

    public String getSubPic2() {
        return subPic2;
    }

    public void setSubPic2(String subPic2) {
        this.subPic2 = subPic2 == null ? null : subPic2.trim();
    }

    public String getSubPic3() {
        return subPic3;
    }

    public void setSubPic3(String subPic3) {
        this.subPic3 = subPic3 == null ? null : subPic3.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}