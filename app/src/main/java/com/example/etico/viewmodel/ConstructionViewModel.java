package com.example.etico.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.etico.model.ConstructionModel;
import com.example.etico.repos.ConstructionPortMaritimeRepository;
import java.util.List;

public class ConstructionViewModel extends AndroidViewModel {

    private ConstructionPortMaritimeRepository repository;
   // private LiveData<List<ConstructionModel>> allConstructionTrackingItems;


    public ConstructionViewModel(@NonNull Application application) {
        super(application);
        repository = new ConstructionPortMaritimeRepository(application);


    }

    public LiveData<List<ConstructionModel>> getAllConstructionTrackingItems()
    {
        return repository.getAllConstructionData();
    }

}
