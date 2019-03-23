package com.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="follow")
public class Follow {
  @Id
  @Column(name="uuid")
  private String uuid;
  
  @Column(name="subject_id")
  private String subjecId;
  
  @Column(name="observer_id")
  private String observeId;
  
  @Column(name="create_id")
  private String createId;
  
  @Column(name="update_id")
  private String updateId;
  
  @Column(name="update_date")
  private String updateDate;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getSubjecId() {
    return subjecId;
  }

  public void setSubjecId(String subjecId) {
    this.subjecId = subjecId;
  }

  public String getObserveId() {
    return observeId;
  }

  public void setObserveId(String observeId) {
    this.observeId = observeId;
  }

  public String getCreateId() {
    return createId;
  }

  public void setCreateId(String createId) {
    this.createId = createId;
  }

  public String getUpdateId() {
    return updateId;
  }

  public void setUpdateId(String updateId) {
    this.updateId = updateId;
  }

  public String getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
  }

}
