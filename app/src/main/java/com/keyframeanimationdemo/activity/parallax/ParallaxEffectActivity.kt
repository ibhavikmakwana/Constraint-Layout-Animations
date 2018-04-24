package com.keyframeanimationdemo.activity.parallax

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.Guideline
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.WindowManager
import com.keyframeanimationdemo.R
import com.keyframeanimationdemo.adapter.Adapter
import kotlinx.android.synthetic.main.activity_parallax_effect.*


class ParallaxEffectActivity : AppCompatActivity() {

    /**
     * Call this method to launch the activity.
     */
    companion object {
        fun launchActivity(context: Context) {
            val intent = Intent(context, ParallaxEffectActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parallax_effect)
        setFullScreen()

        val images = arrayOf(R.drawable.one_bg, R.drawable.two_bg, R.drawable.three_bg, R.drawable.fourth_bg, R.drawable.fifth_bg)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recycler_view)

        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = Adapter(this, images)

        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val manager = recyclerView!!.layoutManager as LinearLayoutManager
                val position = manager.findFirstVisibleItemPosition()
                val lastPosition = manager.findLastVisibleItemPosition()
                val offSet = recyclerView.computeHorizontalScrollOffset()
                for (i in 0..lastPosition - position) {
                    val layout = manager.findViewByPosition(position + i) as ConstraintLayout
                    val guideline = layout.findViewById<Guideline>(R.id.guideline2)
                    val params = guideline.layoutParams as ConstraintLayout.LayoutParams
                    val w = recyclerView.width
                    val deltaPos = offSet - (position + i) * w
                    val percent = deltaPos / w.toFloat()
                    params.guidePercent = Math.max(0.3f, Math.min(0.7f, 0.5f - percent))
                    guideline.layoutParams = params
                }
            }
        })
    }

    private fun setFullScreen() {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}