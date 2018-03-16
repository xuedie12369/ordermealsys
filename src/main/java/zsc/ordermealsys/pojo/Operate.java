package zsc.ordermealsys.pojo;

import java.util.Date;

public class Operate {
    private Integer id;

    private String sellerName;

    private Integer status;

    private Integer autoHandle;

    private Date createTime;

    private Date updateTime;

    public Operate(Integer id, String sellerName, Integer status, Integer autoHandle, Date createTime, Date updateTime) {
        this.id = id;
        this.sellerName = sellerName;
        this.status = status;
        this.autoHandle = autoHandle;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Operate() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAutoHandle() {
        return autoHandle;
    }

    public void setAutoHandle(Integer autoHandle) {
        this.autoHandle = autoHandle;
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