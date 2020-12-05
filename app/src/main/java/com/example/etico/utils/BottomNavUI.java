package com.example.etico.utils;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.etico.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;

import java.lang.ref.WeakReference;
import java.util.Set;

public class BottomNavUI {
    public static boolean onNavDestinationSelected(@NonNull MenuItem item,
                                                   @NonNull NavController navController) {
        int resId = item.getItemId();

        Bundle args = null;
        NavOptions options;

        NavOptions.Builder optionsBuilder = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right);
        if ((item.getOrder() & Menu.CATEGORY_SECONDARY) == 0) {
            optionsBuilder.setPopUpTo(findStartDestination(navController.getGraph()).getId(), false);
        }

        final NavAction navAction = navController.getCurrentDestination().getAction(resId);
        if (navAction != null) {
            NavOptions navOptions = navAction.getNavOptions();

            // Note : You can Add *setLaunchSingleTop* and *setPopUpTo* from *navOptions* to *builder*
            if (navOptions.getEnterAnim() != -1) {
                optionsBuilder.setEnterAnim(navOptions.getEnterAnim());
            }
            if (navOptions.getExitAnim() != -1) {
                optionsBuilder.setExitAnim(navOptions.getExitAnim());
            }
            if (navOptions.getPopEnterAnim() != -1) {
                optionsBuilder.setPopEnterAnim(navOptions.getPopEnterAnim());
            }
            if (navOptions.getPopExitAnim() != -1) {
                optionsBuilder.setPopExitAnim(navOptions.getPopExitAnim());
            }

            Bundle navActionArgs = navAction.getDefaultArguments();
            if (navActionArgs != null) {
                args = new Bundle();
                args.putAll(navActionArgs);
            }
        }

        options = optionsBuilder.build();

        try {
            //TODO provide proper API instead of using Exceptions as Control-Flow.
            navController.navigate(resId, args, options);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void setupWithNavController(
            @NonNull final BottomNavigationView bottomNavigationView,
            @NonNull final NavController navController) {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        return onNavDestinationSelected(item, navController);
                    }
                });
        final WeakReference<BottomNavigationView> weakReference =
                new WeakReference<>(bottomNavigationView);
        navController.addOnDestinationChangedListener(
                new NavController.OnDestinationChangedListener() {
                    @Override
                    public void onDestinationChanged(@NonNull NavController controller,
                                                     @NonNull NavDestination destination, @Nullable Bundle arguments) {
                        BottomNavigationView view = weakReference.get();
                        if (view == null) {
                            navController.removeOnDestinationChangedListener(this);
                            return;
                        }
                        Menu menu = view.getMenu();
                        for (int h = 0, size = menu.size(); h < size; h++) {
                            MenuItem item = menu.getItem(h);
                            if (matchDestination(destination, item.getItemId())) {
                                item.setChecked(true);
                            }
                        }
                    }
                });
    }

    @SuppressWarnings("WeakerAccess") /* synthetic access */
    static boolean matchDestination(@NonNull NavDestination destination,
                                    @IdRes int destId) {
        NavDestination currentDestination = destination;
        while (currentDestination.getId() != destId && currentDestination.getParent() != null) {
            currentDestination = currentDestination.getParent();
        }
        return currentDestination.getId() == destId;
    }

    @SuppressWarnings("WeakerAccess") /* synthetic access */
    static boolean matchDestinations(@NonNull NavDestination destination,
                                     @NonNull Set<Integer> destinationIds) {
        NavDestination currentDestination = destination;
        do {
            if (destinationIds.contains(currentDestination.getId())) {
                return true;
            }
            currentDestination = currentDestination.getParent();
        } while (currentDestination != null);
        return false;
    }

    @SuppressWarnings("WeakerAccess") /* synthetic access */
    static NavDestination findStartDestination(@NonNull NavGraph graph) {
        NavDestination startDestination = graph;
        while (startDestination instanceof NavGraph) {
            NavGraph parent = (NavGraph) startDestination;
            startDestination = parent.findNode(parent.getStartDestination());
        }
        return startDestination;
    }
}

