package com.example.etico.view.port_maritime;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.etico.R;
import com.example.etico.adapter.ConstructionAdapter;
import com.example.etico.callback.OnRecyclerViewITemCLickListener;
import com.example.etico.model.ConstructionModel;
import com.example.etico.utils.HandleNavigationInMainScreenFragments;
import com.example.etico.viewmodel.PortMaritimeViewModel;

import java.util.List;

public class PortMaritimeFragment extends Fragment implements OnRecyclerViewITemCLickListener, Observer<List<ConstructionModel>> {
    private RecyclerView portMaritimeRecyclerView;
    private View view;
    private PortMaritimeViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         view = inflater.inflate(R.layout.fragment_port_m_aaritime, container, false);
         return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        portMaritimeRecyclerView = view.findViewById(R.id.main_port_maritime_recycler_view);
        portMaritimeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        viewModel = new ViewModelProvider(requireActivity()).get(PortMaritimeViewModel.class);
        viewModel.getAllPortMaritimeData().observe(requireActivity(), this);
    }


    @Override
    public void onItemClick(int position) {
        HandleNavigationInMainScreenFragments.navigateTo(view, R.id.action_viewPagerFragment_to_wireRopeSpecificationsFragment);
    }

    @Override
    public void onChanged(List<ConstructionModel> constructionModels) {
        ConstructionAdapter adapter = new ConstructionAdapter(constructionModels, this);
        portMaritimeRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}