package com.sonahjin.savemysearch

import android.app.Activity
import android.app.Application
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatDialog
import android.view.WindowManager
import android.widget.ImageView
import com.sonahjin.savemysearch.base.Foreground
import java.util.concurrent.CopyOnWriteArrayList

class App : Application() {

    private var dialog: AppCompatDialog? = null

    companion object {

        private var instatnce: App? = null
        fun getInstance(): App {
            if (instatnce == null) {
                instatnce = App()
            }
            return instatnce!!
        }
    }


    override fun onCreate() {
        super.onCreate()
        instatnce = this

        if (BuildConfig.DEBUG) {
        }


        Foreground.get(this)!!.addListener(
            object : Foreground.Listener {
                override fun foreground(activity: Activity?) {

                }

                override fun background(activity: Activity?) {

                }
            })
    }



    fun showProgress(activity: Activity?) {

        try {
            if (activity == null || activity.isFinishing) { return }

            if (dialog != null && dialog!!.isShowing) { return }

            dialog = AppCompatDialog(activity)
            dialog!!.setCancelable(false)
            dialog!!.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)
            dialog!!.setContentView(R.layout.progress_loading)
            dialog!!.show()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    fun hideProgress() {

        try {
            if (dialog != null && dialog!!.isShowing) {
                dialog!!.dismiss()
            }
        } catch (e: IllegalArgumentException) {

        }
    }
}