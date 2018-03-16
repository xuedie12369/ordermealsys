package zsc.ordermealsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Integer id;

    private String userName;

    private String pwd;

    private String payPwd;

    private String tel;

    private String nickName;

    private Integer sex;

    private Date birth;

    private Integer age;

    private String email;

    private Integer grade;

    private Integer type;

    private BigDecimal balance;

    private Date creatTime;

    private Integer defAdd;

    private Integer status;

    private Date updateTime;

    private String pic;

    public User(Integer id, String userName, String pwd, String payPwd, String tel, String nickName, Integer sex, Date birth, Integer age, String email, Integer grade, Integer type, BigDecimal balance, Date creatTime, Integer defAdd, Integer status, Date updateTime, String pic) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.payPwd = payPwd;
        this.tel = tel;
        this.nickName = nickName;
        this.sex = sex;
        this.birth = birth;
        this.age = age;
        this.email = email;
        this.grade = grade;
        this.type = type;
        this.balance = balance;
        this.creatTime = creatTime;
        this.defAdd = defAdd;
        this.status = status;
        this.updateTime = updateTime;
        this.pic = pic;
    }

    public User() {
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd == null ? null : payPwd.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getDefAdd() {
        return defAdd;
    }

    public void setDefAdd(Integer defAdd) {
        this.defAdd = defAdd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}