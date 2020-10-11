package com.example.pizzahut;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pizzahut.ui.FragmentFeedback;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

import prihanofficial.com.kokis.logics.Kokis;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private static final float END_SCALE = 0.7f;

    //Drawer Menu
    DrawerLayout drawer;
    NavigationView navigationView;
    LinearLayout contentView;
    Menu menuMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //menu hooks
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        contentView = findViewById(R.id.contentmainpage);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Passing each menu ID as a set of Ids because each


        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_menu,
                R.id.nav_home, R.id.nav_account, R.id.nav_promos, R.id.nav_address, R.id.nav_reset)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        //Navigation Drawer
        navigationView.bringToFront();
        //navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_menu);

        animateNavigationDrawer();

    }

    //navigation drawer functions

    private void animateNavigationDrawer() {

        drawer.setScrimColor(getResources().getColor(R.color.colorRecycler));
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawer.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerVisible(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    //    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch(item.getItemId()){
////            case R.id.nav_storelocator:
////                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
////                        new MapsActivity()).commit();
////                break;
////
//        }
//
//        drawer.closeDrawer(GravityCompat.START);
//
//        return true;
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        menuMe = menu;
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.main_cart_icon) {
            Intent intent = new Intent(this, Cart.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.main_login_icon) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.main_logout_icon) {

            new MaterialAlertDialogBuilder(this,R.style.CustomMaterialDialog)
                    .setTitle("Logout")
                    .setMessage("Are you sure you want to log out?")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            logOut();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .show();

        }

        return super.onOptionsItemSelected(item);
    }

    private void logOut() {
        if (menuMe != null){
            menuMe.findItem(R.id.main_logout_icon).setVisible(false);
            menuMe.findItem(R.id.main_login_icon).setVisible(true);
            menuMe.findItem(R.id.main_cart_icon).setVisible(false);
        }

        Kokis.setKokisBoolean("loginStatus", false);
        Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
    }

}