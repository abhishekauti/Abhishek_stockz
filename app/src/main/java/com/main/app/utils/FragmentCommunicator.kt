package com.main.app.utils

interface FragmentCommunicator {

    //in loginactivity
    fun gotoStartGameFragment(name : String)
    fun gotoInstructionFragment(time:String)
    fun gotoInstructionFragment()
    fun gotoTimerPickerFragment()
//    fun passData(input : String)

}