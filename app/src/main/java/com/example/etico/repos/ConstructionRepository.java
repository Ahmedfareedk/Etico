package com.example.etico.repos;

import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.etico.R;
import com.example.etico.model.ConstructionModel;
import com.example.etico.model.TrackingModel;
import com.example.etico.utils.ListsDataImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructionRepository implements ListsDataImplementation{

    private final MutableLiveData<List<ConstructionModel>> constructionTrackingListLiveData;
    private Application context;
    private final int[] craneDataResources = new int[]{R.array.crawler_cranes,
            R.array.foundation_works, R.array.tower_cranes, R.array.telescopic_mobile_cranes, R.array.truck_mounted_cranes};

    private final int[] cranesIconsResources = new int[]{R.array.crawler_cranes_icons,
            R.array.foundation_works_icons, R.array.tower_cranes_icons,
            R.array.telescopic_cranes_icons, R.array.truck_mounted_cranes_icons};

    public ConstructionRepository(Application context) {
        this.context = context;
        constructionTrackingListLiveData = new MutableLiveData<>();
    }


    //return a list of list of image resources for construction cranes icons
    @Override
    public List<TypedArray> trackingImages() {
        List<TypedArray> constructionIcons = new ArrayList<>();

        for (int i = 0; i < trackingMainTitles().length; i++) {
            constructionIcons.add(i, context.getResources().obtainTypedArray(cranesIconsResources[i]));
        }
        return constructionIcons;
    }
    @Override
    public String[] trackingMainTitles() {
        return context.getResources().getStringArray(R.array.construction_cranes_main_categories);
    }
    @Override
    public List<List<String>> trackingSubTitles() {
        List<List<String>> cranesSubTitles = new ArrayList<>();
        for (int i = 0; i < trackingMainTitles().length; i++) {
            cranesSubTitles.add(i, Arrays.asList(context.getResources().
                    getStringArray(craneDataResources[i])));
        }
        return cranesSubTitles;
    }


    @Override
    public List<ConstructionModel> craneDataList() {
        List<TrackingModel> trackingModelListItem;
        List<ConstructionModel> constructionListItem = new ArrayList<>();

        for (int i = 0; i < trackingMainTitles().length; i++) {
            trackingModelListItem = new ArrayList<>();
            for (int j = 0; j < trackingSubTitles().get(i).size(); j++) {
                trackingModelListItem.add(new TrackingModel(trackingSubTitles().get(i).get(j),
                        trackingImages().get(i).getResourceId(j, -1)));
            }
            constructionListItem.add(i, new ConstructionModel(trackingMainTitles()[i], trackingModelListItem));
        }
        return constructionListItem;
    }

    public LiveData<List<ConstructionModel>> getAllConstructionData() {
        constructionTrackingListLiveData.postValue(craneDataList());
        return constructionTrackingListLiveData;
    }
}
