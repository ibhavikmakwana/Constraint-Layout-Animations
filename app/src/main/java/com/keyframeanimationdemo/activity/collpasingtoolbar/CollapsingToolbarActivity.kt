package com.keyframeanimationdemo.activity.collpasingtoolbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.keyframeanimationdemo.R

class CollapsingToolbarActivity : AppCompatActivity() {

    /**
     * Call this method to launch the activity.
     */
    companion object {
        fun launchActivity(context: Context) {
            val intent = Intent(context, CollapsingToolbarActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar)
    }
}
