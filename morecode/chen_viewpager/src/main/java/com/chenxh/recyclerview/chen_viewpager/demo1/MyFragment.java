package com.chenxh.recyclerview.chen_viewpager.demo1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chenxh.recyclerview.chen_viewpager.E;
import com.chenxh.recyclerview.chen_viewpager.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    public static final String INTENT_INT_INDEX = "index";
    private int tabIndex;

    public static MyFragment newInstance(int tabIndex) {
        Bundle bundle = new Bundle();
        bundle.putInt(INTENT_INT_INDEX, tabIndex);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        E.e(tabIndex+" onStart");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        E.e(tabIndex+" onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.test_fragment,container,false);

        TextView tv = view.findViewById(R.id.test_fragment_tv);
        E.e(tabIndex+" onCreateView");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        E.e(tabIndex+" onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        E.e(tabIndex+" onPause");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        tabIndex = getArguments().getInt(INTENT_INT_INDEX);
        E.e(tabIndex+" onAttach");
    }

    @Override
    public void onStop() {
        super.onStop();
       E.e(tabIndex+" onStop");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        E.e(tabIndex+"onDestroy");
    }
}
