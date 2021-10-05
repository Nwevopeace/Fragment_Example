package com.peacecodes.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var tab_toolbar: Toolbar = findViewById(R.id.tab_toolbar)
        var tab_layout: TabLayout = findViewById(R.id.tab_layout)
        var view_pager: ViewPager = findViewById(R.id.view_pager)

//        setSupportActionBar(tab_toolbar)
        setupViewPager(view_pager)
        tab_layout.setupWithViewPager(view_pager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        var adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(FragmentOne(), "First Fragment")
        adapter.addFragment(FragmentTwo(), "Second Fragment")

        viewPager.setAdapter(adapter)
    }

    class ViewPagerAdapter: FragmentPagerAdapter {

        private var fragmentList1: ArrayList<Fragment> = ArrayList()
        private var fragmentTitleList1: ArrayList<String> = ArrayList()

        constructor(supportFragmentManager: FragmentManager) : super(supportFragmentManager)

        override fun getCount(): Int {
            return fragmentList1.size
        }

        override fun getItem(position: Int): Fragment {
           return fragmentList1.get(position)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentTitleList1.get(position)
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)
        }

    }
}
