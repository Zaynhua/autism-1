package com.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="userdetail")
public class UserDetail {
  @Id
  @Column(name="uuid")
  private String uuid;
  
  @Column(name="register_id")
  private String registerId;
  
  @Column(name="register_time")
  private String registerTime;
  
  @Column(name="last_login_ip")
  private String lastLoginIp;
  
  @Column(name="last_login_time")
  private String lastLoginTime;
  
  @Column(name="login_time_num")
  private int loginTimeNum;
  
  @Column(name="login_day_num")
  private int loginDayNum;
  
  @Column(name="last_comment_time")
  private String lastCommentTime;
  
  @Column(name="comment_num")
  private String commentNum;
  
  @Column(name="excellent_flag")
  private String excellentFlag;
  
  @Column(name="sensitive_flag")
  private String sensitiveFlag;
}
