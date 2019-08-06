package com.sonahjin.savemysearch.utils

import android.content.Context
import android.content.SharedPreferences

class Preference  {

    private var pref: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    private val KEY = "saveMySearch"

    private var context: Context

    constructor(context: Context){
        this.context = context

        pref = this.context.getSharedPreferences(KEY, Context.MODE_PRIVATE)

        if(pref != null) {
            editor = pref!!.edit()
        }
    }



    private fun insertString(key: String, value: String) {
        editor!!.putString(key, value)
        editor!!.commit()
    }

    private fun insertInteger(key: String, value: Int) {
        editor!!.putInt(key, value)
        editor!!.commit()
    }

    private fun insertBoolean(key: String, value: Boolean) {
        editor!!.putBoolean(key, value)
        editor!!.commit()
    }

    private fun selectString(key: String): String? {
        return pref!!.getString(key, null)
    }

    private fun selectInt(key: String): Int {
        return pref!!.getInt(key, 0)
    }

    private fun selectBooleanDftTrue(key: String): Boolean {
        return pref!!.getBoolean(key, true)
    }


    //set / get


    companion object {

        private var instance : Preference? = null

        fun getInstance(context: Context) : Preference {

            if(instance == null) {
                instance =
                    Preference(context)
            }

            return instance!!
        }
    }
}