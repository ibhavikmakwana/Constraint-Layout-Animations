package com.keyframeanimationdemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.keyframeanimationdemo.R
import com.keyframeanimationdemo.activity.circularpositioning.CircularPositioning
import com.keyframeanimationdemo.activity.collpasingtoolbar.CollapsingToolbarActivity
import com.keyframeanimationdemo.activity.keyframeanimation.KeyFrameAnimationActivity
import com.keyframeanimationdemo.activity.keyframeanimation.ShoppingKeyFrameAnimation
import com.keyframeanimationdemo.activity.parallax.ParallaxEffectActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_one.setOnClickListener(this)
        tv_two.setOnClickListener(this)
        tv_collapsing_toolbar.setOnClickListener(this)
        tv_parallax_effect.setOnClickListener(this)
        tv_circular_positioning.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_one -> {
                KeyFrameAnimationActivity.launchActivity(this)
            }
            R.id.tv_two -> {
                ShoppingKeyFrameAnimation.launchActivity(this)
            }
            R.id.tv_collapsing_toolbar -> {
                CollapsingToolbarActivity.launchActivity(this)
            }
            R.id.tv_parallax_effect -> {
                ParallaxEffectActivity.launchActivity(this)
            }
            R.id.tv_circular_positioning -> {
                CircularPositioning.launchActivity(this)
            }
        }
    }
}