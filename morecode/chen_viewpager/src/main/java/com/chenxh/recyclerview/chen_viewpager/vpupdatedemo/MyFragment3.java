package com.chenxh.recyclerview.chen_viewpager.vpupdatedemo;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.chenxh.recyclerview.chen_viewpager.R;
import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base.CFragment3;
import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base.CFragment4;

public class MyFragment3 extends CFragment4 {

    private Button mBtn;

    @Override
    public void initView(View rootView) {
        mBtn = rootView.findViewById(R.id.f3_btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),UPMain2Activity.class));
            }
        });
    }

    @Override
    public int getLayoutRes() {
        return R.layout.test3_fragment;
    }

    @Override
    public void onFragmentLoad() {
        super.onFragmentLoad();
        mBtn.setText("加载中。。。。");
    }

    @Override
    public void onFragmentLoadStop() {
        super.onFragmentLoadStop();
        mBtn.setText("结束更新");
    }
}
