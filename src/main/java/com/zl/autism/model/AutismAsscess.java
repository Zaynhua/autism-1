package com.zl.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//评估表
@Table(name = "autism_assess")
public class AutismAsscess {
    @Id
    @Column(name="uuid")
    private String uuid;

    @Column(name = "intervention_id")
    private String interventionId;

    @Column(name = "interventionist_id")
    private String interventionistId;

    @Column(name = "state")
    private String state;

    @Column(name="start_time")
    private long startTime;

    @Column(name="end_time")
    private long endTime;

    @Column(name = "blog")
    private String blog;

    @Column(name="create_time")
    private int createTime;

    @Column(name="update_time")
    private int updateTime;

    @Column(name="flag")
    private String flag;

    @Transient
    private User docter;

    @Transient
    private User patient;

    public int getCreateTime() {
        return createTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getInterventionId() {
        return interventionId;
    }

    public void setInterventionId(String interventionId) {
        this.interventionId = interventionId;
    }

    public String getInterventionistId() {
        return interventionistId;
    }

    public void setInterventionistId(String interventionistId) {
        this.interventionistId = interventionistId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public User getDocter() {
        return docter;
    }

    public void setDocter(User docter) {
        this.docter = docter;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }
}
