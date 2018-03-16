package zsc.ordermealsys.pojo;

import java.util.Date;

public class Login {
    private Integer id;

    private String userName;

    private Double longitude;

    private Double latitude;

    private String ip;

    private Date logTime;

    private String deviceName;

    private Integer type;

    private Date createTime;

    private Date dateTime;

    public Login(Integer id, String userName, Double longitude, Double latitude, String ip, Date logTime, String deviceName, Integer type, Date createTime, Date dateTime) {
        this.id = id;
        this.userName = userName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.ip = ip;
        this.logTime = logTime;
        this.deviceName = deviceName;
        this.type = type;
        this.createTime = createTime;
        this.dateTime = dateTime;
    }

    public Login() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}