package com.example.dell.taplayout

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dell.navigationdraw.R
import com.example.dell.navigationdraw.R.id.circleIndicator
import com.example.dell.navigationdraw.R.id.view_pager
import com.example.dell.navigationdraw.SlideShowAdapter
import java.util.*
import android.support.v4.view.ViewPager
import android.util.Log
import kotlinx.android.synthetic.main.fragment_item_one.*

class FragmentOne: Fragment(){
/*    private lateinit var mAdapter: SlideShowAdapter
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    private lateinit var mTimer: Timer*/
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_item_one, container, false)
        return view
    }

   /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mAdapter = SlideShowAdapter(view.context)
        view_pager.adapter = mAdapter
        circleIndicator.setViewPager(view_pager)

        mHandler = Handler()
        mRunnable = Runnable {
            var i= view_pager.currentItem

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
    }*/

}