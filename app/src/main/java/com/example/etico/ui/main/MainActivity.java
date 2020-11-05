package com.example.etico.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.etico.R;
import com.example.etico.adapter.TrackViewPagerAdapter;
import com.example.etico.utils.HandleBottomNavView;
import com.example.etico.utils.handle_tab_layout.HandleTabLayoutIcon;
import com.example.etico.utils.handle_tab_layout.HandleTabLayoutTabs;
import com.example.etico.utils.handle_tab_layout.HandleTabLayoutVisibility;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private TabLayout trackTabLayout;
    private ViewPager2 trackViewPager;
    private TrackViewPagerAdapter trackViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.main_nav_view);
        trackTabLayout = findViewById(R.id.tab_layout);
        trackViewPager = findViewById(R.id.trackViewPager);

        trackViewPagerAdapter = new TrackViewPagerAdapter(this);

        navController = Navigation.findNavController(this, R.id.fragment_host);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        trackViewPager.setAdapter(trackViewPagerAdapter);
        HandleTabLayoutTabs.setTabLayoutTabs(trackTabLayout, trackViewPager);
      //  HandleTabLayoutIcon.setTabLayoutIcon(this, trackTabLayout);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if(destination.getId() == R.id.cranesFragment || destination.getId() == R.id.pilingFragment){
                HandleBottomNavView.hideBottomNavigationView(bottomNavigationView);
                HandleTabLayoutVisibility.showTabLayout(trackTabLayout, trackViewPager);

            }
        });


    }
}