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

public class PortMaritimeRepository implements ListsDataImplementation {
    private final int[] portMaritimeSubNamesResources = new int[]{R.array.ship_port_maritime_cranes,
            R.array.offshore_port_maritime_cranes ,R.array.miscellaneous_port_maritime_cranes};
    private Context context;
    private final MutableLiveData<List<ConstructionModel>> allPortMaritimeData;

    public PortMaritimeRepository(Application context) {
        this.context = context;
        allPortMaritimeData = new MutableLiveData();
    }





    @Override
    public String[] trackingMainTitles() {
        return context.getResources().getStringArray(R.array.port_maritime_cranes_main_titles);
    }

    @Override
    public List<List<String>> trackingSubTitles() {
      List<List<String>> portMaritimeSubNames = new ArrayList<>();
        for(int i = 0; i < portMaritimeSubNamesResources.length; i++){
            portMaritimeSubNames.add(i, Arrays.asList(context.getResources().getStringArray(portMaritimeSubNamesResources[i])));
        }
        return portMaritimeSubNames;
    }

    @Override
    public List<TypedArray> trackingImages() {
        return null;
    }

    @Override
    public List<ConstructionModel> craneDataList() {
        List<TrackingModel> trackingModelItem;
        List<ConstructionModel> portMaritimeModels = new ArrayList<>();
        for(int i = 0; i < trackingMainTitles().length; i++){
            trackingModelItem = new ArrayList<>();
            for(int j =0; j < trackingSubTitles().get(i).size(); j++){
                trackingModelItem.add(j, new TrackingModel(trackingSubTitles().get(i).get(j), R.drawable.pedestal));
            }
            portMaritimeModels.add(i, new ConstructionModel(trackingMainTitles()[i], trackingModelItem));
        }
        return portMaritimeModels;
    }
    public LiveData<List<ConstructionModel>> getAllPortMaritimeData()
    {
        allPortMaritimeData.postValue(craneDataList());
        return allPortMaritimeData;
    }
}
