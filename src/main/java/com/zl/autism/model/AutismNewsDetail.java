package com.zl.autism.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "autism_new_detail")
public class AutismNewsDetail {

    @Id
    @Column(name = "news_id")
    private String news_id;

    @Column(name = "new_detail")
    private String new_detail;

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getNew_detail() {
        return new_detail;
    }

    public void setNew_detail(String new_detail) {
        this.new_detail = new_detail;
    }
}
