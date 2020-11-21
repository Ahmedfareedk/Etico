package com.example.etico.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.etico.ui.construction.ConstructionFragment;
import com.example.etico.ui.industrial.IndustrialFragment;
import com.example.etico.ui.port_maritime.PortMaritimeFragment;

import java.util.List;

public class PagerAdapter extends FragmentStateAdapter {
    private List<Fragment> viewFragments;


    public PagerAdapter(@NonNull FragmentActivity fragmentActivity,List<Fragment> viewFragments) {
        super(fragmentActivity);
        this.viewFragments = viewFragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return viewFragments.get(position);
    }
    @Override
    public int getItemCount() {
        return viewFragments.size();
    }
}