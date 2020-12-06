package com.example.etico.ui.construction;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
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
import com.example.etico.model.Crane;
import com.example.etico.utils.HandleNavigationInMainScreenFragments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ConstructionFragment extends Fragment implements OnRecyclerViewITemCLickListener {
    private RecyclerView constructionRecyclerView;
    private TypedArray catogoryTitles;
    private List<List<String>> cranesSubTitles;
    private List<TypedArray> cranesIcons;
    private View view;
    private String[] categoryMainTitles;
    private final int[] craneDataResources = new int[]{R.array.crawler_cranes,
            R.array.foundation_works, R.array.tower_cranes, R.array.telescopic_mobile_cranes, R.array.truck_mounted_cranes};
    private final int[] cranesIconsResources = new int[]{R.array.crawler_cranes_icons,
            R.array.foundation_works_icons, R.array.tower_cranes_icons, R.array.telescopic_cranes_icons, R.array.truck_mounted_cranes_icons};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view =inflater.inflate(R.layout.fragment_construction, container, false);
         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        constructionRecyclerView = view.findViewById(R.id.main_construction_recycler_view);
        categoryMainTitles = getResources().getStringArray(R.array.construction_cranes_categories);
        fillSubCategoriesList();
        fillCraneIconsList();
       // setToolbarTitle();

        ConstructionAdapter adapter = new ConstructionAdapter(constructionListItems(), this);
        constructionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        constructionRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private void fillSubCategoriesList() {
        cranesSubTitles = new ArrayList<>();
        for (int i = 0; i < categoryMainTitles.length; i++) {
            cranesSubTitles.add(i, Arrays.asList(getResources().getStringArray(craneDataResources[i])));
        }
    }

    private List<ConstructionModel> constructionListItems() {
        List<Crane> craneListItem;
        List<ConstructionModel> constructionListItem = new ArrayList<>();

        for (int i = 0; i < categoryMainTitles.length; i++) {
            craneListItem = new ArrayList<>();
            for (int j = 0; j < cranesSubTitles.get(i).size(); j++) {
                craneListItem.add(new Crane(cranesSubTitles.get(i).get(j),cranesIcons.get(i).getResourceId(j, -1)));
            }
            constructionListItem.add(i, new ConstructionModel(categoryMainTitles[i], craneListItem));
        }

        return constructionListItem;
    }
    private void fillCraneIconsList(){
        cranesIcons = new ArrayList<>();
        for(int i = 0; i < cranesIconsResources.length; i++)
            cranesIcons.add(i, getResources().obtainTypedArray(cranesIconsResources[i]));

    }


    @Override
    public void onItemClick(int position) {
        HandleNavigationInMainScreenFragments.navigateTo(view, R.id.action_viewPagerFragment_to_wireRopeSpecificationsFragment);
    }
}