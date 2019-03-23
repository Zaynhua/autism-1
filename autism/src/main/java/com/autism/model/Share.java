package com.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="share")
public class Share {
  @Id
  @Column(name="uuid")
  private String uuid;
  
  @Column(name="project_id")
  private String projectId;
  
  @Column(name="writer_id")
  private String writerId;
  
  @Column(name="sharing_id")
  private String sharingId;
  
  @Column(name="share_time")
  private String shareTime;
  
  @Column(name="share_platform")
  private String sharePlatform;
  
  @Column(name="share_hot")
  private String shareHot;
  
  @Column(name="valid_flag")
  private String validFlag;
  
  @Column(name="create_id")
  private String createId;
  
  @Column(name="create_time")
  private String createTime;
  
  @Column(name="update_id")
  private String updateId;
  
  @Column(name="update_time")
  private String updateTime;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getWriterId() {
    return writerId;
  }

  public void setWriterId(String writerId) {
    this.writerId = writerId;
  }

  public String getSharingId() {
    return sharingId;
  }

  public void setSharingId(String sharingId) {
    this.sharingId = sharingId;
  }

  public String getShareTime() {
    return shareTime;
  }

  public void setShareTime(String shareTime) {
    this.shareTime = shareTime;
  }

  public String getSharePlatform() {
    return sharePlatform;
  }

  public void setSharePlatform(String sharePlatform) {
    this.sharePlatform = sharePlatform;
  }

  public String getShareHot() {
    return shareHot;
  }

  public void setShareHot(String shareHot) {
    this.shareHot = shareHot;
  }

  public String getValidFlag() {
    return validFlag;
  }

  public void setValidFlag(String validFlag) {
    this.validFlag = validFlag;
  }

  public String getCreateId() {
    return createId;
  }

  public void setCreateId(String createId) {
    this.createId = createId;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getUpdateId() {
    return updateId;
  }

  public void setUpdateId(String updateId) {
    this.updateId = updateId;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }
  
}
