package com.example.dell.navigationdraw

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import java.util.logging.Handler

class SlideShowAdapter constructor(context: Context): PagerAdapter(){
    private var context: Context = context
    private lateinit var layoutInflater: LayoutInflater
    val images: IntArray = intArrayOf(
        R.drawable.food_one,
        R.drawable.food_three,
        R.drawable.food_four,
        R.drawable.food_five,
        R.drawable.food_six,
        R.drawable.food_seven
    )

    //p0 -> view: View, p1-> object: Object
    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return (p0 == p1)
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.image_layout, container, false)
        val img: ImageView = view.findViewById(R.id.imageView)
//        img.setImageResource(images[position])
        //Set image to imageView using Glide, since Glide is faster than Picasso
        Glide.with(context).load(images[position]).into(img)
        //Add eventClickListener to each image
        img.setOnClickListener{
            Snackbar.make(img, "Images: " + (position + 1).toString(), 1000).show()
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}