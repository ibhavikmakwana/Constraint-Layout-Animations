package com.keyframeanimationdemo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_shopping_key_frame_animation.*


class ShoppingKeyFrameAnimation : AppCompatActivity() {

    /**
     * Call this method to launch the activity.
     */
    companion object {
        fun launchActivity(context: Context) {
            val intent = Intent(context, ShoppingKeyFrameAnimation::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_key_frame_animation)
        setupAnimations()
    }

    @SuppressLint("SetTextI18n")
    private fun setupAnimations() {
        var show = false
        btn_add_to_bag.setOnClickListener {
            show = if (show) {
                updateConstraints(R.layout.activity_shopping_key_frame_animation)
                btn_add_to_bag.text = resources.getString(R.string.add_to_bag) + " $125"
                false
            } else {
                updateConstraints(R.layout.shopping_activity_select_size)
                btn_add_to_bag.text = "SELECT SIZE"
                true
            }
        }
    }


    private fun updateConstraints(@LayoutRes id: Int) {
        val newConstraintSet = ConstraintSet()
        newConstraintSet.clone(this, id)
        newConstraintSet.applyTo(shopping_cc)
        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()
        transition.duration = 1200
        TransitionManager.beginDelayedTransition(shopping_cc, transition)
    }
}