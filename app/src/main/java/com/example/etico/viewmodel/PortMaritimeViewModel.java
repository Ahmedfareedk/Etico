package com.example.etico.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.etico.model.ConstructionModel;
import com.example.etico.repos.PortMaritimeRepository;

import java.util.List;

public class PortMaritimeViewModel extends AndroidViewModel {

    private PortMaritimeRepository repository;

    public PortMaritimeViewModel(@NonNull Application application) {
        super(application);
        repository = new PortMaritimeRepository(application);
    }

    public LiveData<List<ConstructionModel>> getAllPortMaritimeData()
    {
        return repository.getAllPortMaritimeData();
    }
}
