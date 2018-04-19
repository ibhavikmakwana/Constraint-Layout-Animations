package com.keyframeanimationdemo.utils

import android.animation.ObjectAnimator
import android.view.View

class AnimationHelper(view: View) {
    private var initialValue = 0
    private var target = view

    init {
        initialValue = target.top
    }

    fun evaluate() {
        if (initialValue != target.top) {
            val delta = (initialValue - target.top).toFloat()
            val anim = ObjectAnimator.ofFloat(target, "translationX", delta, 0f)
            anim.duration = 400
            anim.start()
            initialValue = target.top
        }
    }
}