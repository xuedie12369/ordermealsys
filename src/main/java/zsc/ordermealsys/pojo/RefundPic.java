package zsc.ordermealsys.pojo;

import java.util.Date;

public class RefundPic {
    private Integer id;

    private Integer refundId;

    private Date createTime;

    private Date updateTime;

    private String picUrl;

    public RefundPic(Integer id, Integer refundId, Date createTime, Date updateTime, String picUrl) {
        this.id = id;
        this.refundId = refundId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.picUrl = picUrl;
    }

    public RefundPic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }
}