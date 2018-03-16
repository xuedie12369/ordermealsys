package zsc.ordermealsys.pojo;

import java.util.Date;

public class StorePic {
    private Integer id;

    private String sellerName;

    private Date createTime;

    private Date updateTime;

    public StorePic(Integer id, String sellerName, Date createTime, Date updateTime) {
        this.id = id;
        this.sellerName = sellerName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public StorePic() {
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