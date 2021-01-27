package com.example.etico.model;

import java.util.List;

public class ConstructionModel {

    private String craneCategory;
    private List<TrackingModel> subCategoryList;


    public ConstructionModel(String craneCategory, List<TrackingModel> subCategoryList) {
        this.craneCategory = craneCategory;
        this.subCategoryList = subCategoryList;
    }


    public String getCraneCategory() {
        return craneCategory;
    }


    public void setCraneCategory(String craneCategory) {
        this.craneCategory = craneCategory;
    }

    public List<TrackingModel> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<TrackingModel> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}