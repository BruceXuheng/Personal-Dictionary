package com.chenxh.recyclerview.chen_viewpager.vpupdatedemo;

import android.view.ViewGroup;

import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base.CFragment3;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmnetViewPagerAdapter2 extends FragmentPagerAdapter {

    private List<Fragment> mData;

    public MyFragmnetViewPagerAdapter2(@NonNull FragmentManager fm, List<Fragment> datas) {
        super(fm);
        this.mData = datas;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
