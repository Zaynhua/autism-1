package com.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="administrator")
public class Administrator {
  @Id
  @Column(name="userid")
  private String userId;
  
  @Column(name="password")
  private String password;
  
  @Column(name="super_flag")
  private String superFlag;
  
  @Column(name="valid_flag")
  private String validFlag;
  
  @Column(name="create_date")
  private String createDate;
  
  @Column(name="update_date")
  private String updateDate;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSuperFlag() {
    return superFlag;
  }

  public void setSuperFlag(String superFlag) {
    this.superFlag = superFlag;
  }

  public String getValidFlag() {
    return validFlag;
  }

  public void setValidFlag(String validFlag) {
    this.validFlag = validFlag;
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
  
}
