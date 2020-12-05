package com.example.etico.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.etico.R;
import com.example.etico.adapter.PagerAdapter;
import com.example.etico.utils.BottomNavUI;
import com.example.etico.utils.HandleBottomNavView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private Toolbar mainToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.main_nav_view);
        mainToolbar = findViewById(R.id.main_toolbar);

        setSupportActionBar(mainToolbar);

        navController = Navigation.findNavController(this, R.id.fragment_host);
        BottomNavUI.setupWithNavController(bottomNavigationView, navController);


        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.wireRopeFragment || destination.getId() == R.id.sLingFragment || destination.getId() == R.id.shackleHookFragment) {
                HandleBottomNavView.showBottomNavigationView(bottomNavigationView);
            } else HandleBottomNavView.hideBottomNavigationView(bottomNavigationView);

            if (destination.getId() == R.id.endFittingItemsFragment){
                mainToolbar.setTitle("End Fittings");
            }else{
                mainToolbar.setTitle("SLing Force");
            }
        });
    }



    @Override
    public void onBackPressed() {

        if (bottomNavigationView.getSelectedItemId() != R.id.wireRopeFragment){
            bottomNavigationView.setSelectedItemId(R.id.wireRopeFragment);
        }else{
          super.onBackPressed();
        }
    }
}