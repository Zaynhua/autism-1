package com.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="project_info")
public class ProjectInfo {
  
  @Id
  @Column(name="uuid")
  private String uuid;
  
  @Column(name="project_id")
  private String projectId;
  
  @Column(name="collect_num")
  private int collectNum;
  
  @Column(name="comment_num")
  private int commentNum;
  
  @Column(name="view_num")
  private int viewNum;
  
  @Column(name="create_id")
  private String createId;
  
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

  public int getCollectNum() {
    return collectNum;
  }

  public void setCollectNum(int collectNum) {
    this.collectNum = collectNum;
  }

  public int getCommentNum() {
    return commentNum;
  }

  public void setCommentNum(int commentNum) {
    this.commentNum = commentNum;
  }

  public int getViewNum() {
    return viewNum;
  }

  public void setViewNum(int viewNum) {
    this.viewNum = viewNum;
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

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }
  
  
}
