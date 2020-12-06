package com.example.etico.utils;

import android.view.View;

import androidx.navigation.Navigation;

public class HandleNavigationInMainScreenFragments {

    public static void navigateTo(View layout, View inflatedView, int navigateActionId){
        layout.setOnClickListener(v->{
            Navigation.findNavController(inflatedView).navigate(navigateActionId);
        });

    }
}
