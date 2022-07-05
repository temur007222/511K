package com.example.a511k

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class IntroActivity : AppCompatActivity() {

    var viewPager: ViewPager? = null
    var dotsLayout: LinearLayout? = null

    var button: Button? = null

    var adapter: Adapter? = null
    lateinit var dots: Array<TextView?>
    lateinit var textView: TextView
    var animation: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        textView = findViewById(R.id.textView)
        viewPager = findViewById(R.id.slider)
        dotsLayout = findViewById(R.id.dots)

        textView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button = findViewById(R.id.get_started_btn)
        addDots(0)
        with(viewPager) { this?.addOnPageChangeListener(changeListener as ViewPager.OnPageChangeListener)}

        adapter = Adapter(this)
        with(viewPager) { this?.adapter = adapter }
        button!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        })
    }

    private fun addDots(position: Int) {
        dots = arrayOfNulls(3)
        dotsLayout?.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226;")
            dots[i]!!.textSize = 35f
            dotsLayout?.addView(dots[i])
        }
        if (dots.isNotEmpty()) {
            dots[position]!!.setTextColor(resources.getColor(R.color.blue))
        }
    }

    var changeListener: Any = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            addDots(position)
            if (position == 0) {
                button?.visibility = View.INVISIBLE
            } else if (position == 1) {
                button?.visibility = View.INVISIBLE
            } else {
                animation =
                    AnimationUtils.loadAnimation(this@IntroActivity, R.anim.animation)
                button?.animation  = animation
                button?.visibility  = View.VISIBLE
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }
}