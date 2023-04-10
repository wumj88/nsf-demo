package com.netease.cloud.provider.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class UserBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String postDate;

    public UserBean(){}
    public UserBean(Long id, String title, String author, String postDate){
        this.id=id;
        this.name=title;
        this.postDate=postDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPostDate() {
        return postDate;
    }
    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }
    @Override
    public String toString() {
        return "BookBean{" +
                "id='" + id + '\'' +
                ", title='" + name + '\'' +
                ", postDate='" + postDate + '\'' +
                '}';
    }
}

