package com.example.etico.ui.construction;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.etico.R;
import com.example.etico.adapter.ConstructionAdapter;
import com.example.etico.model.ConstructionModel;
import com.example.etico.model.Crane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ConstructionFragment extends Fragment{
    private RecyclerView constructionRecyclerView;
    private TypedArray catogoryTitles;
    private List<TypedArray> cranesTypesTitles;
    private List<List<Crane>> craneItem;



    private List<List<String>> cranesSubTitles;
    private String[] categoryMainTitles;



    private int[] craneDataResources = new int[]{R.array.crawler_cranes,
            R.array.foundation_works, R.array.tower_cranes, R.array.telescopic_mobile_cranes, R.array.truck_mounted_cranes};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_construction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        constructionRecyclerView = view.findViewById(R.id.main_construction_recycler_view);
        categoryMainTitles = getResources().getStringArray(R.array.construction_cranes_categories);
        fillSubCategoriesList();

        ConstructionAdapter adapter = new ConstructionAdapter(setupLists());
        constructionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        constructionRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    

    private void fillSubCategoriesList(){
        cranesSubTitles = new ArrayList<>();
        for(int i = 0; i < categoryMainTitles.length; i++){
            cranesSubTitles.add(i, Arrays.asList(getResources().getStringArray(craneDataResources[i])));
        }
    }

    private List<ConstructionModel> setupLists(){
        List<Crane> craneListItem;
        List<ConstructionModel> constructionListItem = new ArrayList<>();

        for(int i = 0; i < categoryMainTitles.length; i++){
            craneListItem = new ArrayList<>();
            for(int j =0 ; j < cranesSubTitles.get(i).size(); j++){
                craneListItem.add(new Crane(cranesSubTitles.get(i).get(j), R.drawable.overhead));
            }
            constructionListItem.add(i, new ConstructionModel(categoryMainTitles[i], craneListItem));
        }

        return constructionListItem;
    }
}