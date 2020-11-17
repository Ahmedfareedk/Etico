package com.example.etico.ui.port_maritime;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

public class PortMaritimeFragment extends Fragment {
    private RecyclerView portMaritimeRecylcerView;
    private ConstructionAdapter adapter;
    private final int[] portMaritimeCraneNamesResources = new int[]{R.array.ship_port_maritime_cranes,
            R.array.offshore_port_maritime_cranes ,R.array.miscellaneous_port_maritime_cranes};
    private String[] portMaritimeCranesMainTitles;
    private List<List<String>> portMariTimeStringsListToBind;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_port_m_aaritime, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        portMaritimeRecylcerView = view.findViewById(R.id.main_port_maritime_recycler_view);
        portMaritimeCranesMainTitles = getResources().getStringArray(R.array.port_maritime_cranes_main_titles);

        fillStringsListResources();

        adapter = new ConstructionAdapter(portListModelInit());
        portMaritimeRecylcerView.setLayoutManager(new LinearLayoutManager(getContext()));
        portMaritimeRecylcerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void fillStringsListResources(){
     portMariTimeStringsListToBind = new ArrayList<>();
     for(int i = 0; i < portMaritimeCraneNamesResources.length; i++){
         portMariTimeStringsListToBind.add(i, Arrays.asList(getResources().getStringArray(portMaritimeCraneNamesResources[i])));
     }
    }

    private List<ConstructionModel> portListModelInit(){
        List<ConstructionModel> listModel = new ArrayList<>();
        List<Crane> craneItem;
        for(int i = 0; i < portMaritimeCranesMainTitles.length; i++){
            craneItem = new ArrayList<>();
            for(int j =0; j < portMariTimeStringsListToBind.get(i).size(); j++){
                craneItem.add(j, new Crane(portMariTimeStringsListToBind.get(i).get(j), R.drawable.drilling));
            }
            listModel.add(i, new ConstructionModel(portMaritimeCranesMainTitles[i], craneItem));
        }
        return listModel;
    }


}