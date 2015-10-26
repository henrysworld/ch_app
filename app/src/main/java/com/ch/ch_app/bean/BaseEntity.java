package com.ch.ch_app.bean;

/**
 * Created by chenhe on 2015/10/23.
 */
public class BaseEntity {

    private String id;
    private String name;

    public BaseEntity(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
