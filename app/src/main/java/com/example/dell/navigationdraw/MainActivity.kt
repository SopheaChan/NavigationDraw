package com.example.dell.navigationdraw

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import com.example.dell.taplayout.FragmentOne
import com.example.dell.taplayout.FragmentThree
import com.example.dell.taplayout.FragmentTwo
import com.example.dell.taplayout.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
//import com.example.dell.navigationdraw.R.id.*
//import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_layout.*
import kotlinx.android.synthetic.main.fragment_item_one.*
import kotlinx.android.synthetic.main.toolbar_layout.*
import me.relex.circleindicator.CircleIndicator
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var mAdapter: SlideShowAdapter
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    private lateinit var mTimer: Timer

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        val id = p0.itemId
        when (id) {
            R.id.sent -> {
                Toast.makeText(this, "Sent", Toast.LENGTH_SHORT).show()
            }
            R.id.draft -> {
                Toast.makeText(this, "Draft", Toast.LENGTH_SHORT).show()
            }
            R.id.starred -> {
                Toast.makeText(this, "Starred", Toast.LENGTH_SHORT).show()
            }
            R.id.all_mail -> {
                Toast.makeText(this, "All mail", Toast.LENGTH_SHORT).show()
            }
            R.id.delete -> {
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    //Once the drawerLayout is being open, clicking back button on the phone will just close the drawerLayout
    //else, the back button will lead to activity closing as usual
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_layout)

        navigation_view.setNavigationItemSelectedListener(this)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val toggle: ActionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_navigation, R.string.close_navigation)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        mAdapter = SlideShowAdapter(this)
        view_pager.adapter = mAdapter
        circleIndicator.setViewPager(view_pager)

        mHandler = Handler()
        mRunnable = Runnable {
            var i = view_pager.currentItem

            if (i == mAdapter.images.size - 1) {

                i = 0
                view_pager.setCurrentItem(i, true)

            } else {

                i++
                view_pager.setCurrentItem(i, true)
            }
        }

        mTimer = Timer()
        mTimer.schedule(object : TimerTask() {
            override fun run() {

                mHandler.post(mRunnable)
            }
        }, 4000, 4000)


        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(FragmentOne(),getString(R.string.home))
        viewPagerAdapter.addFragment(FragmentTwo(),getString(R.string.new_recipe))
        viewPagerAdapter.addFragment(FragmentThree(),getString(R.string.about_us))

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)


    }
}