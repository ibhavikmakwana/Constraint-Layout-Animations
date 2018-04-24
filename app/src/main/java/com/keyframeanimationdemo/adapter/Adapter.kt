package com.keyframeanimationdemo.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.keyframeanimationdemo.R
import kotlinx.android.synthetic.main.item_parallax_layout.view.*

/**
 * Created by Bhavik Makwana on 30-03-2018.
 */
class Adapter(context: Context, images: Array<Int>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var mImages: Array<Int>
    private var mContext: Context? = null

    init {
        mContext = context
        mImages = images

    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_parallax_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = mImages[position]
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(this.mContext!!, image))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.iv_background_chip!!
    }
}