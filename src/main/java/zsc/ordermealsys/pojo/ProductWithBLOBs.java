package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Service;
public class ProductWithBLOBs extends Product {
    private String mainPic;

    private String subPic;


    private String detail;

    public ProductWithBLOBs(Integer id,Integer categoryId, String sellerName, String name, BigDecimal price, Integer stock, Integer sales, Integer proStatus, Integer delStatus, Date createTime, Date updateTime, BigDecimal deliveryFee, BigDecimal boxFee, BigDecimal boxPrice, String mainPic, String subPic, String detail) {
        super(id, categoryId,sellerName, name, price, stock, sales, proStatus, delStatus, createTime, updateTime, deliveryFee, boxFee, boxPrice);
        this.mainPic = mainPic;
        this.subPic = subPic;
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

    public String getSubPic() {
        return subPic;
    }

    public void setSubPic(String subPic) {
        this.subPic = subPic == null ? null : subPic.trim();
    }

   

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}