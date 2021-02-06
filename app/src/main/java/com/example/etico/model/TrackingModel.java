package com.example.etico.model;

public class TrackingModel {
    private String trackingItemTitle;
    private int trackingItemImage;

    public TrackingModel() {
    }


    public TrackingModel(String trackingItemTitle, int trackingItemImage) {
        this.trackingItemTitle = trackingItemTitle;
        this.trackingItemImage = trackingItemImage;
    }

    public String getTrackingItemTitle() {
        return trackingItemTitle;
    }

    public void setTrackingItemTitle(String trackingItemTitle) {
        this.trackingItemTitle = trackingItemTitle;
    }

    public int getTrackingItemImage() {
        return trackingItemImage;
    }

    public void setTrackingItemImage(int trackingItemImage) {
        this.trackingItemImage = trackingItemImage;
    }
}

