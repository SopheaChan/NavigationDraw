package com.example.dell.navigationdraw

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
//import com.example.dell.navigationdraw.R.id.*
//import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_layout.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
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

    }
}