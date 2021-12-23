package com.main.app

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class CustomDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val alertDialog = AlertDialog.Builder(it)
            alertDialog.setView(requireActivity().layoutInflater.inflate(R.layout.dialog_custom,null))
            alertDialog.setPositiveButton("Okay!",DialogInterface.OnClickListener({dialog, id ->

            }))
            alertDialog.create()

        }?:throw IllegalStateException("Activity is null !!")
    }

}