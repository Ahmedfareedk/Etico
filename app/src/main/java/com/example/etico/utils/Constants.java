package com.example.etico.utils;

import com.example.etico.R;

public interface Constants {

    interface ConstructionDataResources {
        int[] craneTitlesResources = new int[]{R.array.crawler_cranes,
                R.array.foundation_works, R.array.tower_cranes,
                R.array.telescopic_mobile_cranes, R.array.truck_mounted_cranes};

        int[] cranesIconsResources = new int[]{R.array.crawler_cranes_icons,
                R.array.foundation_works_icons, R.array.tower_cranes_icons,
                R.array.telescopic_cranes_icons, R.array.truck_mounted_cranes_icons};

        int cranesMainTitlesResource = R.array.construction_cranes_main_categories;
    }

    interface PortMaritimeResources {
        int portMainTitlesResource = R.array.port_maritime_cranes_main_titles;

        int[] portMaritimeSubNamesResources = new int[]{R.array.ship_port_maritime_cranes,
                R.array.offshore_port_maritime_cranes, R.array.miscellaneous_port_maritime_cranes};

        int[] portMaritimeImages =new int[] {R.array.ship_port_maritime_icons, R.array.offshore_port_maritime_icons, R.array.misc_port_maritime_icons};
    }
}
