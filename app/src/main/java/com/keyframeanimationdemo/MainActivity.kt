package com.keyframeanimationdemo

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var show = false
        iv_background_image.setOnClickListener {
            show = if (show) {
                hideComponents()
                false
            } else {
                showComponents()
                true
            }
        }
    }

    private fun showComponents() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.detail)
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraint, transition)

        constraintSet.applyTo(constraint)
    }

    private fun hideComponents() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_main)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraint, transition)

        constraintSet.applyTo(constraint)
    }
}