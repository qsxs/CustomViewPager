package com.lihb.customviewpager.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * SimpleViewPagerAdapter
 * Created by lihuabin on 2016/11/7.
 */
public class SimpleViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<View> itemViewList;
    private List<String> mTitles;

    public SimpleViewPagerAdapter(Context mContext) {
        this.mContext = mContext;
        itemViewList = new ArrayList<>();
    }

    public SimpleViewPagerAdapter(Context mContext, List<View> itemViewList) {
        this.itemViewList = itemViewList;
        this.mContext = mContext;
    }

    public SimpleViewPagerAdapter(Context mContext, List<View> itemViewList, List<String> mTitles) {
        this.mContext = mContext;
        this.itemViewList = itemViewList;
        this.mTitles = mTitles;
    }

    @Override
    public int getCount() {
        return itemViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(itemViewList.get(position));
        return itemViewList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(itemViewList.get(position));
    }

    public List<String> getTitles() {
        return mTitles;
    }

    public void setTitles(List<String> titles) {
        this.mTitles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles == null) {
            return "";
        }
        return mTitles.get(position);
    }
}
