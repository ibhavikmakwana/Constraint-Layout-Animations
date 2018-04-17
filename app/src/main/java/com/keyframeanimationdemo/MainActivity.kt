package com.keyframeanimationdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_one.setOnClickListener(this)
        tv_two.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_one -> {
                KeyFrameAnimationActivity.launchActivity(this)
            }
            R.id.tv_two -> {
                ShoppingKeyFrameAnimation.launchActivity(this)
            }
        }
    }
}