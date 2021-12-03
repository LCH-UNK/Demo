package base;

import java.util.Date;


public class User {
    private String id;//用户id
    private String contace;//用户姓名
    private String addressDesc;//收货地址明细
    private String postCode;//邮编
    private String tel;//联系人电话
    private String password;//用户密码
    private Date creationDate;//创建时间
    private int modifyBy;//修改者
    private Date modifyDate;//修改时间
    private Integer userid;


    public User() {
    }

    public User(String id, String contace, String addressDesc, String postCode, String tel, String password, Date creationDate, int modifyBy, Date modifyDate, Integer userid) {
        this.id = id;
        this.contace = contace;
        this.addressDesc = addressDesc;
        this.postCode = postCode;
        this.tel = tel;
        this.password = password;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.userid = userid;
    }

    public User(String userCode, String userName, String password, String phone, String address) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContace() {
        return contace;
    }

    public void setContace(String contace) {
        this.contace = contace;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", contace='" + contace + '\'' +
                ", addressDesc='" + addressDesc + '\'' +
                ", postCode=" + postCode +
                ", tel=" + tel +
                ", createdBy='" + password + '\'' +
                ", creationDate=" + creationDate +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate +
                ", userid=" + userid +
                '}';
    }
}
