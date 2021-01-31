package com.example.etico.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.etico.R;
import com.example.etico.model.TrackingModel;
import com.example.etico.repos.SingleDataRepository;

import java.util.List;

public class IndustrialViewModel extends AndroidViewModel {
    private SingleDataRepository repository;

    public IndustrialViewModel(@NonNull Application application) {
        super(application);
        repository = new SingleDataRepository(application, R.array.industrial_cranes_names, R.array.industrial_images);

    }

    public LiveData<List<TrackingModel>> getAllIndustrialTrackingItems() {
        return repository.getAllModelData();
    }
}
