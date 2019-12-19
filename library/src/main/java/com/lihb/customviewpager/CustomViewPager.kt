package com.lihb.customviewpager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * 可以设置是否响应手势切换的viewpager
 * Created by lihuabin on 2016/10/10.
 */
open class CustomViewPager
@JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : ViewPager(context, attrs) {
    var isCanScroll = true

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomViewPager, 0, 0)
        isCanScroll = a.getBoolean(R.styleable.CustomViewPager_canScroll, true)
        a.recycle()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return isCanScroll && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return isCanScroll && super.onInterceptTouchEvent(event)
    }

    fun doOnPageSelected(action: (Int) -> Unit): OnPageChangeListener {
        val listener = object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                action.invoke(position)
            }

        }
        addOnPageChangeListener(listener)
        return listener
    }


}