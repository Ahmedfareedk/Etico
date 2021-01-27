package com.example.etico.callback;

import com.example.etico.model.ConstructionModel;

import java.util.List;

public interface OnConstructionDataChanged {
    void onDataChanged(List<ConstructionModel> modelList);
}
