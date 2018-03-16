package zsc.ordermealsys.pojo;

import java.util.Date;

public class Category {
    private Integer id;

    private Integer parentId;

    private Integer proId;

    private String sellerName;

    private String name;

    private Date createtime;

    private Date updatetime;

    public Category(Integer id, Integer parentId, Integer proId, String sellerName, String name, Date createtime, Date updatetime) {
        this.id = id;
        this.parentId = parentId;
        this.proId = proId;
        this.sellerName = sellerName;
        this.name = name;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Category() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}