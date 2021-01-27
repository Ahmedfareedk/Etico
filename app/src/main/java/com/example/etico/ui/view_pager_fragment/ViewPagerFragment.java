package com.example.etico.ui.view_pager_fragment;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.etico.R;
import com.example.etico.adapter.PagerAdapter;
import com.example.etico.callback.OnConstructionDataChanged;
import com.example.etico.callback.OnIndustrialDataChanged;
import com.example.etico.model.TrackingModel;
import com.example.etico.ui.construction.ConstructionFragment;
import com.example.etico.ui.industrial.IndustrialFragment;
import com.example.etico.ui.port_maritime.PortMaritimeFragment;
import com.example.etico.viewmodel.CranesViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ViewPagerFragment extends Fragment {

    private ViewPager2 viewPager;
    private TabLayout mainTabLayout;
    private OnConstructionDataChanged constructionDataChanged;
    private OnIndustrialDataChanged industrialDataChanged;
    private NavController navController;
    CranesViewModel viewModel;
    public ViewPagerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
//        navController = Navigation.findNavController(view);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.view_pager);
        mainTabLayout = view.findViewById(R.id.main_tab_layout);

        viewPager.setAdapter(new PagerAdapter(getActivity(), getViewFragments()));
        initTabMediator();
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(viewPager.getCurrentItem()!=0){
                    viewPager.setCurrentItem(0);
                }else{
                   // requireActivity().onBackPressed();
                    Navigation.findNavController(view).navigate(R.id.action_viewPagerFragment_to_wireRopeFragment);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

    }


    private List<Fragment> getViewFragments() {
        List<Fragment> viewFragments = new ArrayList<>();
        viewFragments.add(new IndustrialFragment());
        viewFragments.add(new ConstructionFragment());
        viewFragments.add(new PortMaritimeFragment());
        return viewFragments;
    }


    private void initTabMediator() {
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mainTabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Industrial\nCranes");
                    break;
                case 1:
                    tab.setText("Construction\nCranes");

                    break;
                case 2:
                    tab.setText("Port&Maritime\nCranes");
                    break;
            }

        });
        tabLayoutMediator.attach();
    }
}