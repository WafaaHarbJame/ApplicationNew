package com.iapplication.applicationnew.Models;


import java.io.Serializable;

public class CategoryModel implements Serializable {

    // Category Attrs
    private int id;
    private String name;
    private int icon;
    private int  backColor;


    public CategoryModel(int id, String name, int icon, int backColor) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.backColor = backColor;
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

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getBackColor() {
        return backColor;
    }

    public void setBackColor(int backColor) {
        this.backColor = backColor;
    }
}
