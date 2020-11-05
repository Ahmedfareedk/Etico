package com.example.etico.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.etico.ui.cranes.CranesFragment;
import com.example.etico.ui.piling.PilingFragment;

public class TrackViewPagerAdapter extends FragmentStateAdapter {


    public TrackViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new CranesFragment();
            default:
                return new PilingFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
