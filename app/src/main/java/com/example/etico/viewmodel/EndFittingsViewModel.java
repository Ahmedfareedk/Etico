package com.example.etico.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.etico.R;
import com.example.etico.model.TrackingModel;
import com.example.etico.repos.SingleDataRepository;
import java.util.List;

public class EndFittingsViewModel extends AndroidViewModel {
    private final SingleDataRepository repository;

    public EndFittingsViewModel(@NonNull Application application) {
        super(application);
        repository = new SingleDataRepository(application, R.array.end_fittings_titles, R.array.end_fittings_images);
    }

    public LiveData<List<TrackingModel>> getAllEndFittingsData()
    {return  repository.getAllModelData();}
}
