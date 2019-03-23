package com.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="user")
public class User {
  @Id
  @Column(name="id")
  private String id;
  
  @Column(name="name")
  private String name;
  
  @Column(name="nick_name")
  private String nickName;
  
  @Column(name="username")
  private String username;
  
  @Column(name="password")
  private String password;
  
  @Column(name="sex")
  private String sex;
  
  @Column(name="telephone")
  private String telephone;
  
  @Column(name="utype")
  private String utype;
  
  @Column(name="createDate")
  private String createDate;
  
  @Column(name="updateDate")
  private String updateDate;
  
  @Column(name="loginDate")
  private String loginDate;
  
  @Column(name="logoutDate")
  private String logoutDate;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getUtype() {
    return utype;
  }

  public void setUtype(String utype) {
    this.utype = utype;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
  }

  public String getLoginDate() {
    return loginDate;
  }

  public void setLoginDate(String loginDate) {
    this.loginDate = loginDate;
  }

  public String getLogoutDate() {
    return logoutDate;
  }

  public void setLogoutDate(String logoutDate) {
    this.logoutDate = logoutDate;
  }
  
  
}
