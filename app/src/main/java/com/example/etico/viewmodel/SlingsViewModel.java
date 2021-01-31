package com.example.etico.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.etico.R;
import com.example.etico.model.TrackingModel;
import com.example.etico.repos.SingleDataRepository;

import java.util.List;

public class SlingsViewModel extends AndroidViewModel {

    //private final SlingsRepository repository;
    private final SingleDataRepository repository;

    public SlingsViewModel(@NonNull Application application) {
        super(application);
        repository = new SingleDataRepository(application, R.array.slings_titles, R.array.sling_images);
    }

    public LiveData<List<TrackingModel>> getALlSlingsData()
    {
        return  repository.getAllModelData();
    }
}
