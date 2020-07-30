package com.android.study.test_card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.android.study.test_card.adapter.SlideCardLayoutManager;
import com.android.study.test_card.adapter.SlideTouchCallBack;
import com.android.study.test_card.adapter.UniversalAdapter;
import com.android.study.test_card.adapter.ViewHolder;
import com.android.study.test_card.bean.SlideCardBean;
import com.android.study.test_card.config.CardConfig;
import com.bumptech.glide.Glide;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    //数据源
    private List<SlideCardBean> mDatas;

    private UniversalAdapter<SlideCardBean> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv);
        mDatas = SlideCardBean.initDatas();
        adapter = new UniversalAdapter<SlideCardBean>(this, mDatas, R.layout.item_swipe_card) {

            @Override
            public void convert(ViewHolder viewHolder, SlideCardBean slideCardBean) {
                viewHolder.setText(R.id.tvName, slideCardBean.getName());
                viewHolder.setText(R.id.tvPrecent, slideCardBean.getPosition() + "/" + mDatas.size());
                Glide.with(MainActivity.this)
                        .load(slideCardBean.getUrl())
                        .into((ImageView) viewHolder.getView(R.id.iv));
            }
        };
        mRecyclerView.setAdapter(adapter);
        // 初始化数据
        CardConfig.initConfig(this);

        mRecyclerView.setLayoutManager(new SlideCardLayoutManager());

        SlideTouchCallBack touchCallBack = new SlideTouchCallBack(mRecyclerView,adapter,mDatas);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchCallBack);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }


}
