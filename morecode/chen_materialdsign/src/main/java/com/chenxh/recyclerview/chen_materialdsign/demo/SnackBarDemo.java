package com.chenxh.recyclerview.chen_materialdsign.demo;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

class SnackBarDemo {

    public void show(View view){
        Snackbar.make(view, "Hello SnackBar!", Snackbar.LENGTH_LONG).setAction("SnackBarTest", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something
            }
        }).show();
    }

}
