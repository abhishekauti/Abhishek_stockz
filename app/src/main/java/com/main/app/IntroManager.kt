package com.main.app

import android.content.Context
import android.content.SharedPreferences

class IntroManager {
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var context : Context
    constructor(context: Context?) {
        this.context = context!!
        pref = context.getSharedPreferences("first",0)
        editor = pref.edit()
    }

    fun setFirst(isFirst : Boolean) {
        editor.putBoolean("check",isFirst)
        editor.commit()
        
    }
    fun checkFirst() : Boolean{
        return pref.getBoolean("check",true)
    }
}