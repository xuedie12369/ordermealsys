package zsc.ordermealsys.pojo;

import java.util.Date;

public class StorePicWithBLOBs extends StorePic {
    private String environmentPic;

    private String licensePic;

    public StorePicWithBLOBs(Integer id, String sellerName, Date createTime, Date updateTime, String environmentPic, String licensePic) {
        super(id, sellerName, createTime, updateTime);
        this.environmentPic = environmentPic;
        this.licensePic = licensePic;
    }

    public StorePicWithBLOBs() {
        super();
    }

    public String getEnvironmentPic() {
        return environmentPic;
    }

    public void setEnvironmentPic(String environmentPic) {
        this.environmentPic = environmentPic == null ? null : environmentPic.trim();
    }

    public String getLicensePic() {
        return licensePic;
    }

    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic == null ? null : licensePic.trim();
    }
}