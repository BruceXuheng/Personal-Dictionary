package com.chenxh.recyclerview.chen_materialdsign.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chenxh.recyclerview.chen_materialdsign.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetsActivity extends AppCompatActivity {

    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheets);
        nestedScrollView = findViewById(R.id.bottom_sheet);
        final BottomSheetBehavior<NestedScrollView> from = BottomSheetBehavior.from(nestedScrollView);
        from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("chenxh","from.getState()="+from.getState());
                if(from.getState()==BottomSheetBehavior.STATE_EXPANDED){
                    from.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else{
                    from.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                new SnackBarDemo().show(findViewById(R.id.btnShow));
            }
        });
        findViewById(R.id.btnShow1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(BottomSheetsActivity.this);
                View bt = getLayoutInflater().inflate(R.layout.activity_material_text, null);
                mBottomSheetDialog.setContentView(bt);
                mBottomSheetDialog.show();
            }
        });

    }
}