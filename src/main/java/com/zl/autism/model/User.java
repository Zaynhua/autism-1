package com.zl.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;


@Table(name="autism_user")
public class User {
    @Id
    @Column(name="uuid")
    private String uuid;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="type")
    private String type;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="sex")
    private String sex;

    @Column(name="real_name")
    private String realName;

    @Column(name="nation")
    private String nation;

    @Column(name="address")
    private String address;

    @Column(name="qualification_number")
    private String qualificationNumber;

    @Column(name="work_time")
    private long workTime;

    @Column(name="dept_id")
    private String deptId;

    @Column(name="create_time")
    private int createTime;

    @Column(name="update_time")
    private int updateTime;

    @Column(name="flag")
    private String flag;

    @Column(name="open_id")
    private String openId;

    private ArrayList<User> relatedUser;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getQualificationNumber() {
        return qualificationNumber;
    }

    public void setQualificationNumber(String qualificationNumber) {
        this.qualificationNumber = qualificationNumber;
    }

    public long getWorkTime() {
        return workTime;
    }

    public void setWorkTime(long workTime) {
        this.workTime = workTime;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public ArrayList<User> getrelatedUser() {
        return relatedUser;
    }

    public void setrelatedUser(ArrayList<User> relatedUser) {
        this.relatedUser = relatedUser;
    }
}
