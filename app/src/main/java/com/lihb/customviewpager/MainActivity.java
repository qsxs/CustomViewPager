package com.lihb.customviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import com.lihb.library.CustomViewPager;
import com.lihb.library.indicator.CirclePageIndicator;

public class MainActivity extends AppCompatActivity {
    private CirclePageIndicator indicator;
    private CustomViewPager vp;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indicator = findViewById(R.id.indicator);
        vp = findViewById(R.id.vp);
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                TextView tv = new TextView(container.getContext());
                tv.setText("pager " + position);
                if (position == 0) {
                    tv.setBackgroundColor(Color.BLUE);
                } else if (position == 1) {
                    tv.setBackgroundColor(Color.YELLOW);
                } else {
                    tv.setBackgroundColor(Color.GREEN);
                }
                container.addView(tv);
                return tv;
            }
        });
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp.setCanScroll(!vp.isCanScroll());
                Toast.makeText(MainActivity.this, "isCanScroll:" + vp.isCanScroll(), Toast.LENGTH_SHORT).show();
            }
        });
        indicator.setViewPager(vp);
    }
}
