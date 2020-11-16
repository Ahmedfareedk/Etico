package com.example.etico.model;

import java.util.List;

public class ConstructionModel {

    private String craneCategory;
    private List<Crane> subCategoryList;


    public ConstructionModel(String craneCategory, List<Crane> subCategoryList) {
        this.craneCategory = craneCategory;
        this.subCategoryList = subCategoryList;
    }


    public String getCraneCategory() {
        return craneCategory;
    }


    public void setCraneCategory(String craneCategory) {
        this.craneCategory = craneCategory;
    }

    public List<Crane> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Crane> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }


}