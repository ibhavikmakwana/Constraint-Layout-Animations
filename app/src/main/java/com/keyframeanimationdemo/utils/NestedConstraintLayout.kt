package com.keyframeanimationdemo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.keyframeanimationdemo.R

/**
 * Created by Bhavik Makwana on 19-04-2018.
 */
class NestedConstraintLayout : ConstraintLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttribute: Int) : super(context, attrs, defStyleAttribute)

    private val mHideSet: ConstraintSet = ConstraintSet()
    private val mShowSet: ConstraintSet = ConstraintSet()
    private var mBtnAddToBag: Button? = null


    private var mProductImage: ImageView? = null
    private var mProductName: TextView? = null
    private var mProductDesc: TextView? = null
    private var mSelectSize: TextView? = null
    private var mSize: Button? = null

    private var mTranslationProductImage: AnimationHelper? = null
    private var mTranslationProductName: AnimationHelper? = null
    private var mTranslationProductDesc: AnimationHelper? = null
    private var mTranslationSelecteSize: AnimationHelper? = null
    private var mTranslationSize: AnimationHelper? = null


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mHideSet.clone(context, R.layout.layout_shopping_activity_invisble_size)
        mShowSet.clone(context, R.layout.layout_shopping_activity_select_size)
        mBtnAddToBag = findViewById(R.id.btn_add_to_bag)
        mProductImage = findViewById(R.id.iv_product_image)
        mProductName = findViewById(R.id.tv_product_name)
        mProductDesc = findViewById(R.id.tv_product_desc)
        mSelectSize = findViewById(R.id.tv_select_size)
        mSize = findViewById(R.id.size)

        setupAnimations()
    }


    @SuppressLint("SetTextI18n")
    private fun setupAnimations() {
        var show = false
        mBtnAddToBag?.setOnClickListener {
            show = if (show) {
                updateConstraints(R.layout.activity_shopping_key_frame_animation)
                mBtnAddToBag?.text = resources.getString(R.string.add_to_bag) + " $125"
                false
            } else {
                updateConstraints(R.layout.layout_shopping_activity_select_size)
                mBtnAddToBag?.text = "SELECT SIZE"
                true
            }
        }
    }

    private fun updateConstraints(@LayoutRes id: Int) {
//        val newConstraintSet = ConstraintSet()
//        newConstraintSet.clone(context, id)
//        newConstraintSet.applyTo(shopping_cc)
//        val transition = ChangeBounds()
//        transition.interpolator = OvershootInterpolator()
//        transition.duration = 1200
//        TransitionManager.beginDelayedTransition(shopping_cc, transition)

        if (mProductImage != null && mTranslationProductImage == null) {
            mTranslationProductImage = AnimationHelper(mProductImage!!)
        }
        if (mProductName != null && mTranslationProductName == null) {
            mTranslationProductName = AnimationHelper(mProductName!!)
        }
        if (mProductDesc != null && mTranslationProductDesc == null) {
            mTranslationProductDesc = AnimationHelper(mProductDesc!!)
        }
        if (mSelectSize != null && mTranslationSelecteSize == null) {
            mTranslationSelecteSize = AnimationHelper(mSelectSize!!)
        }
        if (mSize != null && mTranslationSize == null) {
            mTranslationSize = AnimationHelper(mSize!!)
        }

        mTranslationProductImage?.evaluate()
        mTranslationProductName?.evaluate()
        mTranslationProductDesc?.evaluate()
        mTranslationSelecteSize?.evaluate()
        mTranslationSize?.evaluate()
    }
}