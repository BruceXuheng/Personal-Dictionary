package com.chenxh.recyclerview.chen_materialdsign.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.os.Bundle;
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

    }
}