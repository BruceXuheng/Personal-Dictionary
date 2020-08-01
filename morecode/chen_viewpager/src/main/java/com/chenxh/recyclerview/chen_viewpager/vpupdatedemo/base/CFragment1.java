package com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 解决对于fragment不可见时 对视图更新造成的问题
 */
public abstract class CFragment1 extends Fragment {

    private View rootView;
    private boolean isViewCreated;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutRes(), container, false);
        }
        isViewCreated = true;
        initView(rootView);
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isViewCreated) {
            if (isVisibleToUser) {
                dispatchUserVisibleHint(true);
            } else {
                dispatchUserVisibleHint(false);
            }
        }

    }

    // 分发可见不可见的动作
    private void dispatchUserVisibleHint(boolean b) {
        if (b) {
            // 加载数据
            onFragmentLoad();
        } else {
            // 停止一切操作
            onFragmentLoadStop();
        }
    }

    public abstract void initView(View rootView);

    public abstract int getLayoutRes();

    // -->>>停止网络数据请求
    public void onFragmentLoadStop() {
        E("onFragmentLoadStop");
    }

    // -->>>加载网络数据请求
    public void onFragmentLoad() {
        E("onFragmentLoad");
    }


    @Override
    public void onResume() {
        super.onResume();
        E("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        E("onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        E("onDestroyView");
    }

    private void E(String string) {
        Log.e("chenxh", "输出=" + string);
//        if (mFragmentDelegater != null) {
//            mFragmentDelegater.dumpLifeCycle(string);
//        }
    }
}
