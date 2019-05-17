package com.zl.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "autism_communitys")
public class AutismCommunitys {

    @Id
    @Column(name = "communitys_id")
    private String communitys_id;

    @Column(name = "communitys_pic")
    private String communitys_pic;

    @Column(name = "communitys_see")
    private String communitys_see;

    @Column(name = "communitys_intro")
    private String communitys_intro;

    @Column(name = "communitys_like")
    private String communitys_like;

    @Column(name = "communitys_author")
    private String communitys_author;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "communitys_city")
    private String communitys_city;

    public String getCommunitys_id() {
        return communitys_id;
    }

    public void setCommunitys_id(String communitys_id) {
        this.communitys_id = communitys_id;
    }

    public String getCommunitys_pic() {
        return communitys_pic;
    }

    public void setCommunitys_pic(String communitys_pic) {
        this.communitys_pic = communitys_pic;
    }

    public String getCommunitys_see() {
        return communitys_see;
    }

    public void setCommunitys_see(String communitys_see) {
        this.communitys_see = communitys_see;
    }

    public String getCommunitys_intro() {
        return communitys_intro;
    }

    public void setCommunitys_intro(String communitys_intro) {
        this.communitys_intro = communitys_intro;
    }

    public String getCommunitys_like() {
        return communitys_like;
    }

    public void setCommunitys_like(String communitys_like) {
        this.communitys_like = communitys_like;
    }

    public String getCommunitys_author() {
        return communitys_author;
    }

    public void setCommunitys_author(String communitys_author) {
        this.communitys_author = communitys_author;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCommunitys_city() {
        return communitys_city;
    }

    public void setCommunitys_city(String communitys_city) {
        this.communitys_city = communitys_city;
    }
}
