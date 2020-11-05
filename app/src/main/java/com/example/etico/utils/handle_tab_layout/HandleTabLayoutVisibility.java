package com.example.etico.utils.handle_tab_layout;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class HandleTabLayoutVisibility {

    public static void showTabLayout(TabLayout tabLayout, ViewPager2 viewPager){
        tabLayout.setVisibility(View.VISIBLE);
        viewPager.setVisibility(View.VISIBLE);
    }
}
