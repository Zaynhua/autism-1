package com.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="user")
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
  
  @Column(name="province")
  private String province;
  
  @Column(name="create_time")
  private long createTime;
  
  @Column(name="update_time")
  private long updateTime;
  
  @Column(name="flag")
  private String flag;
  
  @Column(name="open_id")
  private String openId;
  
  public String getUuid() {
	  return uuid;
  }

  public void setUuid(String uuid) {
	  this.uuid = uuid;
  }

  public String getName() {
	  return name;
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

  public String getEmail() {
	  return email;
  }

  public void setEmail(String email) {
	  this.email = email;
  }

  public String getSex() {
	  return sex;
  }

  public void setSex(String sex) {
	  this.sex = sex;
  }

  public String getProvince() {
	return province;
  }

  public void setProvince(String province) {
	this.province = province;
  }

public long getCreateTime() {
	  return createTime;
  }

  public void setCreateTime(long createTime) {
	  this.createTime = createTime;
  }

  public long getUpdateTime() {
	  return updateTime;
  }

  public void setUpdateTime(long updateTime) {
	  this.updateTime = updateTime;
  }

  public String getFlag() {
	  return flag;
  }

  public void setFlag(String flag) {
	  this.flag = flag;
  }

  public String getOpenId() {
	  return openId;
  }

  public void setOpenId(String openId) {
	  this.openId = openId;
  }
  
  
}
