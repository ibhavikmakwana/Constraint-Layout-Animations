package com.keyframeanimationdemo.activity.circularpositioning

import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.keyframeanimationdemo.R
import kotlinx.android.synthetic.main.activity_orbits.*
import java.util.concurrent.TimeUnit


class CircularPositioning : AppCompatActivity() {

    /**
     * Call this method to launch the activity.
     */
    companion object {
        fun launchActivity(context: Context) {
            val intent = Intent(context, CircularPositioning::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orbits)


        val earthAnimator = animatePlanet(earth_image, TimeUnit.SECONDS.toMillis(2))
        val marsAnimator = animatePlanet(mars_image, TimeUnit.SECONDS.toMillis(6))
        val saturnAnimator = animatePlanet(saturn_image, TimeUnit.SECONDS.toMillis(12))

        updateConstraints(R.layout.activity_orbits)
        startAnimation(earthAnimator, marsAnimator, saturnAnimator)

        var show = true
        sun_image.setOnClickListener({
            show = if (show) {
                cancelAnim(earthAnimator, marsAnimator, saturnAnimator)
                updateConstraints(R.layout.layout_orbits_details)
                false
            } else {
                startAnimation(earthAnimator, marsAnimator, saturnAnimator)
                updateConstraints(R.layout.activity_orbits)
                true
            }
        })
    }

    private fun updateConstraints(@LayoutRes id: Int) {
        val newConstraintSet = ConstraintSet()
        newConstraintSet.clone(this, id)
        newConstraintSet.applyTo(root)
        TransitionManager.beginDelayedTransition(root)
    }

    private fun cancelAnim(earthAnimator: ValueAnimator, marsAnimator: ValueAnimator, saturnAnimator: ValueAnimator) {
        earthAnimator.cancel()
        marsAnimator.cancel()
        saturnAnimator.cancel()
    }

    private fun startAnimation(earthAnimator: ValueAnimator, marsAnimator: ValueAnimator, saturnAnimator: ValueAnimator) {
        earthAnimator.start()
        marsAnimator.start()
        saturnAnimator.start()
    }

    private fun animatePlanet(planet: ImageView?, orbitDuration: Long): ValueAnimator {
        val anim = ValueAnimator.ofInt(0, 359)
        anim.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Int
            val layoutParams = planet?.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.circleAngle = value.toFloat()
            planet.layoutParams = layoutParams
            anim.duration = orbitDuration
            anim.interpolator = LinearInterpolator()
            anim.repeatMode = ValueAnimator.RESTART
            anim.repeatCount = ValueAnimator.INFINITE
        }
        return anim
    }
}
