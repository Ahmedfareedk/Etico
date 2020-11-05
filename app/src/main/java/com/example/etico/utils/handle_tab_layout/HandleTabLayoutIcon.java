package com.example.etico.utils.handle_tab_layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.etico.R;
import com.google.android.material.tabs.TabLayout;

public class HandleTabLayoutIcon {

    public static int[] icons = new int[]{R.drawable.ic_crane, R.drawable.ic_piling};

    public static void setTabLayoutIcon(Context context, TabLayout tabLayout){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for(int i =0; i < icons.length; i++){
            View view = inflater.inflate(R.layout.custom_tab, null);
            TabLayout.Tab tab = tabLayout.getTabAt(i);
         //   view.findViewById(R.id.custom_tab_icon_image).setBackgroundResource(icons[i]);
            if (tab!=null) tab.setCustomView(view);
        }
    }
}
