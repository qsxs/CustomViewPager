package com.lihb.customviewpager

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.lihb.customviewpager.adapter.FragmentViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        vp.adapter = getAdapter(3)
        vp.adapter = FragmentViewPagerAdapter(supportFragmentManager, arrayListOf(FragmentFirst(), FragmentSecond()))
        btn.setOnClickListener(View.OnClickListener {
            vp.isCanScroll = !vp.isCanScroll
            //                vp.setAdapter(null);
            indicator.notifyDataSetChanged()
            Toast.makeText(this@MainActivity, "isCanScroll:" + vp.isCanScroll, Toast.LENGTH_SHORT).show()
        })
        indicator.setViewPager(vp)
    }

    private fun getAdapter(size: Int): PagerAdapter {
        return object : PagerAdapter() {
            override fun getCount(): Int {
                return size
            }

            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                return view === `object`
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                container.removeView(`object` as View)
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val tv = TextView(container.context)
                tv.text = "pager $position"
                if (position % 3 == 0) {
                    tv.setBackgroundColor(Color.BLUE)
                } else if (position % 3 == 1) {
                    tv.setBackgroundColor(Color.YELLOW)
                } else {
                    tv.setBackgroundColor(Color.GREEN)
                }
                container.addView(tv)
                return tv
            }
        }
    }
}