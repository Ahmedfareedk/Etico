package com.example.etico.ui.industrial;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.etico.R;
import com.example.etico.adapter.IndustrialCranesAdapter;
import com.example.etico.model.Crane;

import java.util.ArrayList;
import java.util.List;

public class IndustrialFragment extends Fragment {
    private RecyclerView cranesRecyclerView;
    private IndustrialCranesAdapter cranesAdapter;
    private List<Crane> craneList;
    private String[] craneNamesArray;
    private TypedArray craneImagesArray;

    public IndustrialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_industrial, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cranesRecyclerView = view.findViewById(R.id.industrial_cranes_recycler);
        craneNamesArray = getResources().getStringArray(R.array.industrial_cranes_names);
        craneImagesArray = getResources().obtainTypedArray(R.array.industrial_images);
        fillCranesList();

        cranesAdapter = new IndustrialCranesAdapter(craneList);
        cranesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cranesRecyclerView.setAdapter(cranesAdapter);
        cranesAdapter.notifyDataSetChanged();

    }

    private void fillCranesList(){
        craneList = new ArrayList<>();
        for(int i =0; i<craneNamesArray.length; i++){
            craneList.add(i, new Crane(craneNamesArray[i], craneImagesArray.getResourceId(i,-1)));
        }
    }

}