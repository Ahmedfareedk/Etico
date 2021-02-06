package com.example.etico.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.etico.model.ConstructionModel;
import com.example.etico.repos.NestedDataRepository;
import com.example.etico.utils.Constants;

import java.util.List;

public class ConstructionViewModel extends AndroidViewModel {

    private NestedDataRepository repository;


    public ConstructionViewModel(@NonNull Application application) {
        super(application);
        repository = new NestedDataRepository(application,Constants.ConstructionDataResources.cranesMainTitlesResource,
                Constants.ConstructionDataResources.craneTitlesResources, Constants.ConstructionDataResources.cranesIconsResources);


    }

    public LiveData<List<ConstructionModel>> getAllConstructionTrackingItems()
    {
        return repository.getAllModelData();
    }

}
