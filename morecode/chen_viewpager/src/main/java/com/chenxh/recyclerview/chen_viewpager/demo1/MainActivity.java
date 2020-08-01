package com.chenxh.recyclerview.chen_viewpager.demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.chenxh.recyclerview.chen_viewpager.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private MyFragmnetViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

    }

    private void initData() {

        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(MyFragment.newInstance(1));
        fragments.add(MyFragment.newInstance(2));
        fragments.add(MyFragment.newInstance(3));
        fragments.add(MyFragment.newInstance(4));
        fragments.add(MyFragment.newInstance(5));

        adapter = new MyFragmnetViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.fragment_1:
                        viewPager.setCurrentItem(0,true);
                       return true;
                    case R.id.fragment_2:
                        viewPager.setCurrentItem(1,true);
                        return true;
                    case R.id.fragment_3:
                        viewPager.setCurrentItem(2,true);
                        return true;
                    case R.id.fragment_4:
                        viewPager.setCurrentItem(3,true);
                        return true;
                    case R.id.fragment_5:
                        viewPager.setCurrentItem(4,true);
                        return true;
                }
                return false;
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int itemId = R.id.fragment_1;
                switch (position){
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
                bottomNavigationView.setSelectedItemId(itemId);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {

        viewPager = findViewById(R.id.viewpager);
        bottomNavigationView = findViewById(R.id.main_bnv);

    }


}
