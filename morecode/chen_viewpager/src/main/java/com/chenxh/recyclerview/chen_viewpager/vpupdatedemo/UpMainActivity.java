package com.chenxh.recyclerview.chen_viewpager.vpupdatedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.chenxh.recyclerview.chen_viewpager.R;
import com.chenxh.recyclerview.chen_viewpager.demo1.MyFragmnetViewPagerAdapter;
import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.base.CFragment3;
import com.chenxh.recyclerview.chen_viewpager.vpupdatedemo.vp2.Fragment2;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class UpMainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private BottomNavigationView mBtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_main);

        mVp = findViewById(R.id.up_vp);
        mBtv = findViewById(R.id.up_bnv);

        MyFragmnetViewPagerAdapter2 adapter = new MyFragmnetViewPagerAdapter2(getSupportFragmentManager(), getDatas());
        mVp.setAdapter(adapter);
        mVp.setOffscreenPageLimit(3);
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int itemId = R.id.fragment_1;

                switch (position) {
                    case 0:
                        itemId = R.id.fragment_1;
                        break;
                    case 1:
                        itemId = R.id.fragment_2;
                        break;
                    case 2:
                        itemId = R.id.fragment_3;
                        break;
                    case 3:
                        itemId = R.id.fragment_4;
                        break;
                    case 4:
                        itemId = R.id.fragment_5;
                        break;
                }
                mBtv.setSelectedItemId(itemId);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBtv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.fragment_1:
                        mVp.setCurrentItem(0);
                        return true;
                    case R.id.fragment_2:
                        mVp.setCurrentItem(1);
                        return true;
                    case R.id.fragment_3:
                        mVp.setCurrentItem(2);
                        return true;
                    case R.id.fragment_4:
                        mVp.setCurrentItem(3);
                        return true;
                    case R.id.fragment_5:
                        mVp.setCurrentItem(4);
                        return true;
                }
                return false;
            }
        });


    }

    private List<Fragment> getDatas() {

        List<Fragment> datas = new ArrayList<>();
        datas.add(new MyFragment2());
        datas.add(new Fragment2());
        datas.add(new MyFragment2());
        datas.add(new MyFragment2());
        datas.add(new MyFragment3());
        return datas;

    }

}