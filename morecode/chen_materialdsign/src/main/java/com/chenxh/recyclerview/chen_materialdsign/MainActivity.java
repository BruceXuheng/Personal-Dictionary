package com.chenxh.recyclerview.chen_materialdsign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.chenxh.recyclerview.chen_materialdsign.adapter.OnItemClickListener;
import com.chenxh.recyclerview.chen_materialdsign.adapter.UniversalAdapter;
import com.chenxh.recyclerview.chen_materialdsign.adapter.ViewHolder;
import com.chenxh.recyclerview.chen_materialdsign.demo.BottomSheetsActivity;
import com.chenxh.recyclerview.chen_materialdsign.demo.ChipActivity;
import com.chenxh.recyclerview.chen_materialdsign.demo.CoordinatorActivity;
import com.chenxh.recyclerview.chen_materialdsign.demo.DrawerActivity;
import com.chenxh.recyclerview.chen_materialdsign.demo.MaterialButtonActivity;
import com.chenxh.recyclerview.chen_materialdsign.demo.MaterialTextActivity;
import com.chenxh.recyclerview.chen_materialdsign.demo.ToolBarActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRv = findViewById(R.id.main_recy);

        mData = new ArrayList<>();
        mData.add("CoordinatorLayout");
        mData.add("ToolbarLayout");
        mData.add("MaterialButtonLayout");
        mData.add("DrawerLayout");
        mData.add("Material Text");
        mData.add("Chips");
        mData.add("BottomSheets");

        mRv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        mRv.setAdapter(new UniversalAdapter<String>(this,mData,R.layout.recycler_view_item_main) {
            @Override
            public void convert(ViewHolder var1, final String var2) {
                var1.setText(R.id.tv_main_recy,var2);
                var1.getView(R.id.tv_main_recy).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (var2){
                            case "CoordinatorLayout":
                                startActivity(new Intent(MainActivity.this,CoordinatorActivity.class));
                                break;
                            case "ToolbarLayout":
                                startActivity(new Intent(MainActivity.this, ToolBarActivity.class));
                                break;
                            case "MaterialButtonLayout":
                                startActivity(new Intent(MainActivity.this, MaterialButtonActivity.class));
                                break;
                            case "DrawerLayout":
                                startActivity(new Intent(MainActivity.this, DrawerActivity.class));
                                break;
                            case "Material Text":
                                startActivity(new Intent(MainActivity.this, MaterialTextActivity.class));
                                break;
                            case "BottomSheets":
                                startActivity(new Intent(MainActivity.this, BottomSheetsActivity.class));
                                break;
                            case "Chips":
                                startActivity(new Intent(MainActivity.this, ChipActivity.class));
                                break;

                        }
                    }
                });
            }

        });

    }


}
