package com.example.etico.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.etico.model.ConstructionModel;
import com.example.etico.repos.NestedDataRepository;
import com.example.etico.utils.Constants;

import java.util.List;

public class PortMaritimeViewModel extends AndroidViewModel {

    private NestedDataRepository repository;

    public PortMaritimeViewModel(@NonNull Application application) {
        super(application);
        repository = new NestedDataRepository(application, Constants.PortMaritimeResources.portMainTitlesResource,
                Constants.PortMaritimeResources.portMaritimeSubNamesResources, Constants.PortMaritimeResources.portMaritimeImages);
    }

    public LiveData<List<ConstructionModel>> getAllPortMaritimeData()
    {
        return repository.getAllModelData();
    }
}
