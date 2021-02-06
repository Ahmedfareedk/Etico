package com.example.etico.utils;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.etico.R;
import com.example.etico.model.ConstructionModel;
import com.example.etico.model.TrackingModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface NestedListsDataImplementation {

     String[] trackingMainTitles();

    List<List<String>> trackingSubTitles();

    List<TypedArray> trackingImages();

    List<ConstructionModel> craneDataList();
}