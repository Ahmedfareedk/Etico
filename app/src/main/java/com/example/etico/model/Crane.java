package com.example.etico.model;

public class Crane {
    private String craneTitle;
    private int craneImage;

    public Crane() {
    }

    public Crane(String craneTitle, int craneImage) {
        this.craneTitle = craneTitle;
        this.craneImage = craneImage;
    }

    public String getCraneTitle() {
        return craneTitle;
    }

    public void setCraneTitle(String craneTitle) {
        this.craneTitle = craneTitle;
    }

    public int getCraneImage() {
        return craneImage;
    }

    public void setCraneImage(int craneImage) {
        this.craneImage = craneImage;
    }


}
