package zsc.ordermealsys.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer proId;

    private String buyerName;

    private String sellerName;

    private Integer proType;

    private Integer storeType;

    private String proComContent;

    private String serComContent;

    private Date createTime;

    private Date updateTime;

    public Comment(Integer id, Integer proId, String buyerName, String sellerName, Integer proType, Integer storeType, String proComContent, String serComContent, Date createTime, Date updateTime) {
        this.id = id;
        this.proId = proId;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
        this.proType = proType;
        this.storeType = storeType;
        this.proComContent = proComContent;
        this.serComContent = serComContent;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
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

    public Integer getProType() {
        return proType;
    }

    public void setProType(Integer proType) {
        this.proType = proType;
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public String getProComContent() {
        return proComContent;
    }

    public void setProComContent(String proComContent) {
        this.proComContent = proComContent == null ? null : proComContent.trim();
    }

    public String getSerComContent() {
        return serComContent;
    }

    public void setSerComContent(String serComContent) {
        this.serComContent = serComContent == null ? null : serComContent.trim();
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