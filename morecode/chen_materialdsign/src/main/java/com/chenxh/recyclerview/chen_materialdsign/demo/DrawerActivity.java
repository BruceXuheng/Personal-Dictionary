package com.chenxh.recyclerview.chen_materialdsign.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.chenxh.recyclerview.chen_materialdsign.R;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        drawerLayout.openDrawer(Gravity.LEFT);

        CountDownTimer timer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                drawerLayout.closeDrawer(Gravity.LEFT);

            }
        }.start();
        NavigationView viewById = findViewById(R.id.nav_view);
        viewById.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.END);
                return false;
            }
        });


    }
}