package com.sonahjin.savemysearch.base

import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import com.sonahjin.savemysearch.App
import com.sonahjin.savemysearch.R



open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun showProgress() {
        App.getInstance().showProgress(this)
    }

    fun  hideProgress() {
        App.getInstance().hideProgress()
    }


    fun showToast(msg : String) {
        Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
    }

    fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (currentFocus != null)
            imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }

    fun showKeyboard(editText: EditText) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
    }


}