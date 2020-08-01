package com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.vp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenxh.recyclerview.chen_viewpager.R;
import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base.CFragment5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2_vp_2 extends CFragment5 {

    public static Fragment newIntance() {
        Fragment2_vp_2 fragment = new Fragment2_vp_2();
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_vp_2;
    }

    @Override
    public void initView(View view) { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
