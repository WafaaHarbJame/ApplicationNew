package com.iapplication.applicationnew.Models;

import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;

public class LocationModel implements Serializable {

    // Category Attrs
    private int id;
    private String name;
    private String icon;

    private static RequestOptions requestOptions;

    public LocationModel(int id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;

        requestOptions = new RequestOptions().circleCrop();
    }

    public LocationModel(int id, String name) {
        this.id = id;
        this.name = name;

        requestOptions = new RequestOptions().circleCrop();
    }
    public LocationModel() {
        requestOptions = new RequestOptions().circleCrop();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}
