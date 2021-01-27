package com.example.etico.repos;

import android.content.Context;
import android.content.res.TypedArray;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.etico.R;
import com.example.etico.model.ConstructionModel;
import com.example.etico.model.TrackingModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndustrialCranesRepository {
    private Context context;


    private  MutableLiveData<List<TrackingModel>> trackingListLiveData;


    public IndustrialCranesRepository(Context context) {
        this.context = context;
        trackingListLiveData = new MutableLiveData<>();

    }

    private String[] industrialTrackingItemNames() {
        return context.getResources().getStringArray(R.array.industrial_cranes_names);
    }



    private TypedArray industrialTrackingItemImages() {
        return context.getResources().obtainTypedArray(R.array.industrial_images);
    }

    private List<TrackingModel> trackingModelList() {
        List<TrackingModel> trackingModelList = new ArrayList<>();
        for (int i = 0; i < industrialTrackingItemNames().length; i++) {
            trackingModelList.add(i, new TrackingModel(industrialTrackingItemNames()[i], industrialTrackingItemImages().getResourceId(i, -1)));
        }
        return trackingModelList;
    }




    public LiveData<List<TrackingModel>> getAllIndustrialData() {

        trackingListLiveData.postValue(trackingModelList());
        return trackingListLiveData;
    }


}


