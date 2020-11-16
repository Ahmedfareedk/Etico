package com.example.etico.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import com.example.etico.R;
import com.example.etico.utils.HandleBottomNavView;
import com.google.android.material.bottomnavigation.BottomNavigationView;



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
        mainToolbar.setTitle("Etico");
        setSupportActionBar(mainToolbar);


        navController = Navigation.findNavController(this, R.id.fragment_host);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if(destination.getId() == R.id.wireRopeFragment || destination.getId() == R.id.sLingFragment||destination.getId() == R.id.shackleHookFragment){
                HandleBottomNavView.showBottomNavigationView(bottomNavigationView);
            } else HandleBottomNavView.hideBottomNavigationView(bottomNavigationView);


        });


    }
}