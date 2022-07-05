package com.example.a511k

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.airbnb.lottie.LottieAnimationView

open class Adapter( var context: Context) : PagerAdapter() {

    var layoutInflater: LayoutInflater? = null

    var imagesArray = intArrayOf(
        R.raw.fraglottie,
        R.raw.secondfraglottie,
        R.raw.thirdfraglottie
    )

    var headingArray = arrayOf(
        "Say Hello to \n Global Top-Up",
        "Safe, Trusted & \n Fully Secure",
        "Easy to Use"
    )

    var descriptionArray = arrayOf(
        "Send mobile top-up to more than 500 networks in over 140 countries.",
        "Encrypted transactions mean your payments & Privacy and protected.",
        "Pick a number, choose an amount, send your Top-up. Simple."
    )

    override fun getCount(): Int {return headingArray.size}

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
        }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.layout_screen, container, false)
        val lottieAnimationView = view.findViewById<LottieAnimationView>(R.id.lottie)
        val lottieAnimationView2 = view.findViewById<LottieAnimationView>(R.id.lottie2)
        val lottieAnimationView3 = view.findViewById<LottieAnimationView>(R.id.lottie3)
        val heading = view.findViewById<TextView>(R.id.heading)
        val description = view.findViewById<TextView>(R.id.description)
        lottieAnimationView.setAnimation(imagesArray[position])
        lottieAnimationView2.setAnimation(imagesArray[position])
        lottieAnimationView3.setAnimation(imagesArray[position])
        heading.text = headingArray[position]
        description.text = descriptionArray[position]
        container.addView(view)
        return view
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}