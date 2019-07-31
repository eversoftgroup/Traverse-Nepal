package com.eversoft.models;

public class home_model {

    private int image;
    private String title;
    public home_model(int image, String title) {
        this.image = image;
        this.title = title;
    }
    public int getImage() {
        return image;
    }
    public String getTitle() {
        return title;
    }
}
