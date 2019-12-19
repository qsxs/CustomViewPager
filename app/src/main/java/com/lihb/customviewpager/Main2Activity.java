package com.lihb.customviewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        CustomViewPager vp = findViewById(R.id.vp);
        vp.isCanScroll();
    }
}
