package com.iapplication.applicationnew.Models;

public class SliderModel {
    private int id;
    private String slider_image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlider_image() {
        return slider_image;
    }

    public void setSlider_image(String slider_image) {
        this.slider_image = slider_image;
    }

    public SliderModel(int id, String slider_image) {
        this.id = id;
        this.slider_image = slider_image;
    }
}
