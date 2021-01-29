package com.example.etico.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.etico.model.TrackingModel;
import com.example.etico.repos.IndustrialCranesRepository;
import java.util.List;

public class CranesViewModel extends AndroidViewModel {
    private IndustrialCranesRepository repository;

    public CranesViewModel(@NonNull Application application) {
        super(application);
        repository = new IndustrialCranesRepository(application);

    }

    public LiveData<List<TrackingModel>> getAllIndustrialTrackingItems() {
        return repository.getAllIndustrialData();
    }
}
