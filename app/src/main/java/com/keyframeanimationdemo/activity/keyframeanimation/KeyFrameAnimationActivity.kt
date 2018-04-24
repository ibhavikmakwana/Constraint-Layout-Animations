package com.keyframeanimationdemo.activity.keyframeanimation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import com.keyframeanimationdemo.R
import kotlinx.android.synthetic.main.activity_key_frame_animation.*

class KeyFrameAnimationActivity : AppCompatActivity() {


    /**
     * Call this method to launch the activity.
     */
    companion object {
        fun launchActivity(context: Context) {
            val intent = Intent(context, KeyFrameAnimationActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key_frame_animation)

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
        constraintSet.clone(this, R.layout.activity_key_frame_animation)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraint, transition)

        constraintSet.applyTo(constraint)
    }
}