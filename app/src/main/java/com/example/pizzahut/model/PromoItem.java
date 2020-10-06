package com.example.pizzahut.model;

public class PromoItem {
    private int id;
    private int image;
    private String promDetails;

    public PromoItem(int id, int image, String promDetails) {
        this.id = id;
        this.image = image;
        this.promDetails = promDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {

        return image;
    }

    public void setImage(int image) {

        this.image = image;
    }

    public String getPromDetails() {
        return promDetails;
    }

    public void setPromDetails(String promDetails) {
        this.promDetails = promDetails;
    }
}
