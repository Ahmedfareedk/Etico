package com.example.etico.callback;

import com.example.etico.model.TrackingModel;

import java.util.List;

public interface OnIndustrialDataChanged {

    void onDataChanged(List<TrackingModel> trackingModels);
}
