package com.zero.materialdesign.nestedscroll.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.zero.materialdesign.databinding.ActivityNestScrollBinding;

public class NestScrollActivity extends AppCompatActivity {

    private ActivityNestScrollBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNestScrollBinding.inflate(getLayoutInflater());
        Log.e("chenxh","binding.getRoot()="+binding.getRoot());
        setContentView(binding.getRoot());

    }
}