package com.chenxh.recyclerview.chen_viewpager.vpupdatedemo;

import android.view.View;
import android.widget.TextView;

import com.chenxh.recyclerview.chen_viewpager.R;
import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base.CFragment1;
import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base.CFragment2;
import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base.CFragment3;
import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base.CFragment4;

public class MyFragment2 extends CFragment4 {

    private TextView tv;

    @Override
    public void initView(View rootView) {
        tv = rootView.findViewById(R.id.test_fragment_tv);

    }

    @Override
    public int getLayoutRes() {
        return R.layout.test_fragment;
    }

    @Override
    public void onFragmentLoad() {
        super.onFragmentLoad();
        tv.setText("加载中。。。。");
    }

    @Override
    public void onFragmentLoadStop() {
        super.onFragmentLoadStop();
        tv.setText("结束更新");
    }
}
