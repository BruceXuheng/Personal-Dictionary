package com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.vp2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenxh.recyclerview.chen_viewpager.R;
import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base.CFragment5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// 同学们：这是T2  嵌套了一层 ViewPager的Fragment2_vp_1
public class Fragment2_vp_1 extends CFragment5 {

    private static final String TAG = "Fragment2_vp_1";

    public static Fragment newIntance() {
        Fragment2_vp_1 fragment = new Fragment2_vp_1();
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_vp_1;
    }

    @Override
    public void initView(View view) {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onFragmentLoadStop() {
        super.onFragmentLoadStop();
        Log.d(TAG, "onFragmentLoadStop" + " 停止一切更新");
    }

    @Override
    public void onFragmentLoad() {
        super.onFragmentLoad();
        Log.d(TAG, "onFragmentLoad" + " 真正更新数据");
    }
}
