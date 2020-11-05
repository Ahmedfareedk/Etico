package com.example.etico.utils.handle_tab_layout;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.example.etico.R;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HandleTabLayoutTabs {

    public static void setTabLayoutTabs(TabLayout tabLayout, ViewPager2 viewPager){
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {

            switch (position)
            {
                case 0:
                    tab.setText("Cranes");
                //    tab.setIcon(R.drawable.ic_crane);
                    break;
                case 1:
                    tab.setText("Piling");
                //    tab.setIcon(R.drawable.ic_piling);
                    break;
            }

        });

        tabLayoutMediator.attach();
    }
}
