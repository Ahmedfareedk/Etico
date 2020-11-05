package com.example.etico.utils;

import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HandleBottomNavView {

    public static void hideBottomNavigationView(BottomNavigationView navigationView){
        navigationView.setVisibility(View.GONE);
    }
}
