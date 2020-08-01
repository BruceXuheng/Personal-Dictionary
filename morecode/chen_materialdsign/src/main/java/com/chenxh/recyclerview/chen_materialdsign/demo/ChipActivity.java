package com.chenxh.recyclerview.chen_materialdsign.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.chenxh.recyclerview.chen_materialdsign.R;
import com.google.android.material.chip.ChipDrawable;

public class ChipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chip);

        final EditText editText = findViewById(R.id.et_test);
        findViewById(R.id.chip0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChipDrawable chipDrawable = ChipDrawable.createFromResource(ChipActivity.this, R.xml.chip_test);
                chipDrawable.setBounds(0, 0, chipDrawable.getIntrinsicWidth(), chipDrawable.getIntrinsicHeight());
                ImageSpan span = new ImageSpan(chipDrawable);
                Editable text = editText.getText();
                chipDrawable.setText(text.toString());
                text.setSpan(span, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        });
        SeekBar seekBar = findViewById(R.id.seekbar);
        final ImageView imageView = findViewById(R.id.iv_show);
        final TextView viewById = findViewById(R.id.tv_info);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int max = seekBar.getMax();
                double scale = (double)progress/(double)max;
                ClipDrawable drawable = (ClipDrawable) imageView.getBackground();
                drawable.setLevel((int) (10000*scale));
                viewById.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}