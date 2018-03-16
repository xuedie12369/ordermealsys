package zsc.ordermealsys.pojo;

import java.util.Date;

public class Store {
    private Integer id;

    private String sellerName;

    private String storeName;

    private Integer grade;

    private Integer integral;

    private String desc;

    private String nation;

    private String province;

    private String city;

    private String county;

    private String town;

    private String detailAdd;

    private Double longitude;

    private Double latitude;

    private String school;

    private Date createTime;

    private Date updateTime;

    public Store(Integer id, String sellerName, String storeName, Integer grade, Integer integral, String desc, String nation, String province, String city, String county, String town, String detailAdd, Double longitude, Double latitude, String school, Date createTime, Date updateTime) {
        this.id = id;
        this.sellerName = sellerName;
        this.storeName = storeName;
        this.grade = grade;
        this.integral = integral;
        this.desc = desc;
        this.nation = nation;
        this.province = province;
        this.city = city;
        this.county = county;
        this.town = town;
        this.detailAdd = detailAdd;
        this.longitude = longitude;
        this.latitude = latitude;
        this.school = school;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Store() {
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public String getDetailAdd() {
        return detailAdd;
    }

    public void setDetailAdd(String detailAdd) {
        this.detailAdd = detailAdd == null ? null : detailAdd.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
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