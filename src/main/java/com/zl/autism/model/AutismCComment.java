package com.zl.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "autism_communitys_comment")
public class AutismCComment {

    @Id
    @Column(name = "communitys_comment_id")
    private String communitys_comment_id;

    @Column(name = "communitys_id")
    private String communitys_id;

    @Column(name = "comment_user_id")
    private String comment_user_id;

    @Column(name = "communitys_comment")
    private String communitys_comment;

    @Column(name = "communitys_comment_time")
    private String communitys_comment_time;

    @Column(name = "communitys_comment_name")
    private String communitys_comment_name;


    public String getCommunitys_id() {
        return communitys_id;
    }

    public void setCommunitys_id(String communitys_id) {
        this.communitys_id = communitys_id;
    }


    public String getCommunitys_comment_id() {
        return communitys_comment_id;
    }

    public void setCommunitys_comment_id(String communitys_comment_id) {
        this.communitys_comment_id = communitys_comment_id;
    }

    public String getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(String comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public String getCommunitys_comment() {
        return communitys_comment;
    }

    public void setCommunitys_comment(String communitys_comment) {
        this.communitys_comment = communitys_comment;
    }

    public String getCommunitys_comment_time() {
        return communitys_comment_time;
    }

    public void setCommunitys_comment_time(String communitys_comment_time) {
        this.communitys_comment_time = communitys_comment_time;
    }

    public String getCommunitys_comment_name() {
        return communitys_comment_name;
    }

    public void setCommunitys_comment_name(String communitys_comment_name) {
        this.communitys_comment_name = communitys_comment_name;
    }
}
