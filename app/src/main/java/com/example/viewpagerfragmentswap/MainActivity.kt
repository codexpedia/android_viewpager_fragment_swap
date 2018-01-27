package com.example.viewpagerfragmentswap

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

// https://github.com/danilao/fragments-viewpager-example/tree/master/src/com/pineappslab/frcontainer
class MainActivity : AppCompatActivity() {

    val NUM_ITEMS = 5
    private lateinit var mPagerAdapter: SlidePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPagerAdapter = SlidePagerAdapter(supportFragmentManager)
        pager.adapter = mPagerAdapter

        pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (position > 1) {
                    // java.lang.IllegalArgumentException: No view found for id 0x7f070055 (com.example.viewpagerfragmentswap:id/root_frame) for fragment SecondFragment
                    for (i in 0 until supportFragmentManager.backStackEntryCount) {
                        supportFragmentManager.popBackStack()
                    }
                }
            }
        })

    }

    inner class SlidePagerAdapter(val fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {

            return if (position == 0) {
                RootFragment() // This is where we create a RootFragment acting as a container for other fragments
            } else {
                StaticFragment()
            }
        }

        override fun getCount(): Int {
            return NUM_ITEMS
        }
    }
}
