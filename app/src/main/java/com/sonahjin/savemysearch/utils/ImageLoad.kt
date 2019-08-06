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

//    /**
//     * 이미지 사이즈에 맞춰 View의 높이를 이미지 크기에 맞게 자동으로 변경
//     * (View, LinearLayout 적용가능)
//     * @param context
//     * @param imageUrl
//     * @param view
//     */
//    fun setAutoSizeView(context: Context, imageUrl: String, width:Int, height:Int, view: ImageView) {
//
//       // image url에 연결해서 이미지의 width, height를 받아온다.
//        Glide.with(context)
//            .load(imageUrl)
//            .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//            .into(object : SimpleTarget<GlideDrawable>() {
//                override fun onResourceReady(
//                    glideDrawable: GlideDrawable,
//                    glideAnimation: GlideAnimation<in GlideDrawable>
//                ) {
//                    val imageHeight = glideDrawable.intrinsicHeight
//                    val imageWidth = glideDrawable.intrinsicWidth
//
//                    // 파라미터로 받아온 width, height를 view에 적용한다.
//                    val vto = view.viewTreeObserver
//                    vto.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//                        override fun onGlobalLayout() {
//                            view.viewTreeObserver.removeGlobalOnLayoutListener(this)
//                            val width = view.measuredWidth
//                            val height = width * imageHeight / imageWidth
//
//                            view.layoutParams = LinearLayout.LayoutParams(width, height)
//                        }
//                    })
//                }
//            })
//    }
}