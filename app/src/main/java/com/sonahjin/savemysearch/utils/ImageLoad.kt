package com.sonahjin.savemysearch.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import jp.wasabeef.glide.transformations.CropCircleTransformation
import android.widget.LinearLayout
import android.view.ViewTreeObserver
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget


class ImageLoad{

    fun setImageResource(imageView: ImageView, url: String, placeHolder: Drawable) {
        if (TextUtils.isEmpty(url)) {
            imageView.setImageDrawable(placeHolder)
        } else {

            Glide.with(imageView.context)
                .load(url.trim { it <= ' ' })
                .crossFade()
                .placeholder(placeHolder)
                .error(placeHolder)
                .into(imageView)
        }
    }

}