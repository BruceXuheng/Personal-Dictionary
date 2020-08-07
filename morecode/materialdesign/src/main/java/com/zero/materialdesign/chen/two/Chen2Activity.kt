package com.zero.materialdesign.chen.two

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.zero.materialdesign.R
import com.zero.materialdesign.md2.adapter.MyFragmentAdapter
import com.zero.materialdesign.md2.fragment.NestedTestFragment
import kotlinx.android.synthetic.main.activity_chen2.*

class Chen2Activity : AppCompatActivity() {


    var fragmentList:MutableList<Fragment> = mutableListOf();
    var titleList:MutableList<String> = mutableListOf();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chen2)


        initData();


        val adapter:MyFragmentAdapter = MyFragmentAdapter(this,fragmentList)
        view_pager.adapter = adapter

        TabLayoutMediator(tab,view_pager,object:TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = titleList.get(position)
            }
        }).attach()

//        tab;
//
//        view_pager;

    }

    private fun initData() {
        fragmentList.add(NestedTestFragment.newIntance("1"))
        fragmentList.add(NestedTestFragment.newIntance("2"))
        fragmentList.add(NestedTestFragment.newIntance("3"))
        fragmentList.add(NestedTestFragment.newIntance("4"))
        titleList.add("首页")
        titleList.add("商品")
        titleList.add("个人")
        titleList.add("关于")
    }


}
