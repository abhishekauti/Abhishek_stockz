package com.main.app.viewmodels

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.main.app.splashscreen.LoginActivity
import com.main.app.utils.FragmentCommunicator

class LoginViewModel : ViewModel() {

    fun enterLogin(name: String, context : Context)
    {
        if (name.isNotBlank()){
            val loginacticity = LoginActivity()
            val communicator = loginacticity as FragmentCommunicator
            communicator.gotoStartGameFragment(name)
        }
        else {
            Toast.makeText(context,"Please Enter your Name", Toast.LENGTH_SHORT).show()


        }
    }

}