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
 * 解决fragment跳转Activity 返回，没执行分发
 * 具体核心处理标注为【核心】
 */
public abstract class CFragment4 extends Fragment {

    private View rootView;
    private boolean isViewCreated;
    private boolean isVisibleStateUP = false; // TODO 记录上一次可见的状态


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutRes(), container, false);
        }
        isViewCreated = true;
        initView(rootView);
        if(getUserVisibleHint()){
            setUserVisibleHint(true);
        }
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isViewCreated) {

            //当前可见、上次不可见 --》执行 数据加载
            //当前不可见、上次可见 --》执行 数据结束加载

            if (isVisibleToUser && !isVisibleStateUP) {
                dispatchUserVisibleHint(true);
            } else if(!isVisibleToUser && isVisibleStateUP) {
                dispatchUserVisibleHint(false);
            }
        }

    }

    // 分发可见不可见的动作
    private void dispatchUserVisibleHint(boolean b) {
        // 记录上一次可见的状态 实时更新状态
        this.isVisibleStateUP = b;
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
        //【核心】不可见 到 可见  变化过程  说明 可见
        if(getUserVisibleHint() && !isVisibleStateUP){
            dispatchUserVisibleHint(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        E("onPause");
        //【核心】可见 到 不可见  变化过程  说明 不可见
        if(getUserVisibleHint() && isVisibleStateUP){
            dispatchUserVisibleHint(false);
        }
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
