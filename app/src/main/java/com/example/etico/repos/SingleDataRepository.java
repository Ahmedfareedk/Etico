package com.example.etico.repos;

import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.etico.R;
import com.example.etico.model.TrackingModel;

import java.util.ArrayList;
import java.util.List;

public class SingleDataRepository  {

    private Context context;
    private int titlesResourceId;
    private int imagesResourceId;

    private final MutableLiveData<List<TrackingModel>> allModelData;

    public SingleDataRepository(Context context, int titlesResourceId, int imagesResourceId) {
        this.context = context;
        this.titlesResourceId = titlesResourceId;
        this.imagesResourceId = imagesResourceId;
        allModelData = new MutableLiveData<>();
    }

    public String[] trackingItemNames() {
        return context.getResources().getStringArray(titlesResourceId);
    }

    public TypedArray trackingItemImages() {

        return context.getResources().obtainTypedArray(imagesResourceId);
    }


    public List<TrackingModel> trackingModelList() {
        List<TrackingModel> trackingModelList = new ArrayList<>();

        for (int i = 0; i < trackingItemNames().length; i++)
        {
            trackingModelList.add(i, new TrackingModel(trackingItemNames()[i], trackingItemImages().getResourceId(i, -1)));
        }
        return trackingModelList;
    }

    public LiveData<List<TrackingModel>> getAllModelData()
    {
        allModelData.postValue(trackingModelList());
        return allModelData;
    }
}
