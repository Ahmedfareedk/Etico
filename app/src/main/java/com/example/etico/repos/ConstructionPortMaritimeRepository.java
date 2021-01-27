package com.example.etico.repos;

import android.app.Application;
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

public class ConstructionPortMaritimeRepository {

    private MutableLiveData<List<ConstructionModel>> constructionTrackingListLiveData;
    private Application context;
    private final int[] craneDataResources = new int[]{R.array.crawler_cranes,
            R.array.foundation_works, R.array.tower_cranes, R.array.telescopic_mobile_cranes, R.array.truck_mounted_cranes};

    private final int[] cranesIconsResources = new int[]{R.array.crawler_cranes_icons,
            R.array.foundation_works_icons, R.array.tower_cranes_icons,
            R.array.telescopic_cranes_icons, R.array.truck_mounted_cranes_icons};

    public ConstructionPortMaritimeRepository(Application context) {
        this.context = context;
        constructionTrackingListLiveData = new MutableLiveData<>();
    }


    //return a list of list of image resources for construction cranes icons
    private List<TypedArray> constructionTrackingImages() {
        List<TypedArray> constructionIcons = new ArrayList<>();

        for (int i = 0; i < constructionMainTitles().length; i++) {
            constructionIcons.add(i, context.getResources().obtainTypedArray(cranesIconsResources[i]));
        }
        return constructionIcons;
    }

    private String[] constructionMainTitles() {
        return context.getResources().getStringArray(R.array.construction_cranes_main_categories);
    }

    private List<List<String>> constructionTrackingSubNames() {
        List<List<String>> cranesSubTitles = new ArrayList<>();
        for (int i = 0; i < constructionMainTitles().length; i++) {
            cranesSubTitles.add(i, Arrays.asList(context.getResources().
                    getStringArray(craneDataResources[i])));
        }
        return cranesSubTitles;
    }


    private List<ConstructionModel> constructionListData() {
        List<TrackingModel> trackingModelListItem;
        List<ConstructionModel> constructionListItem = new ArrayList<>();

        for (int i = 0; i < constructionMainTitles().length; i++) {
            trackingModelListItem = new ArrayList<>();
            for (int j = 0; j < constructionTrackingSubNames().get(i).size(); j++) {
                trackingModelListItem.add(new TrackingModel(constructionTrackingSubNames().get(i).get(j),
                        constructionTrackingImages().get(i).getResourceId(j, -1)));
            }
            constructionListItem.add(i, new ConstructionModel(constructionMainTitles()[i], trackingModelListItem));
        }
        return constructionListItem;
    }


    public LiveData<List<ConstructionModel>> getAllConstructionData() {

        constructionTrackingListLiveData.postValue(constructionListData());
        return constructionTrackingListLiveData;
    }
}
