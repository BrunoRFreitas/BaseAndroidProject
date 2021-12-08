package com.brfdev.ui_components.utils

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog

class DialogUtils {

    private lateinit var dialog: AlertDialog

    fun showDialog(
        activity: Activity,
        title: String?,
        msg: String?,
        setCancelable: Boolean,
        positiveButton: String?,
        positiveClick: DialogInterface.OnClickListener?
    ): AlertDialog? {
        return showDialog(
            activity,
            title,
            msg,
            setCancelable,
            positiveButton,
            positiveClick,
            null,
            null
        )
    }

    fun showDialog(
        activity: Activity,
        title: String?,
        msg: String?,
        setCancelable: Boolean,
        positiveButton: String?,
        positiveClick: DialogInterface.OnClickListener?,
        negativeButton: String?,
        negativeClick: DialogInterface.OnClickListener?
    ): AlertDialog? {
//        dialog.dismiss()
        val builder = AlertDialog.Builder(activity)
        var dialog: Dialog = builder.create()
        val dialogWindow = dialog.window
        dialogWindow?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        builder.setTitle(title ?: "")
        builder.setMessage(msg ?: "")
        if (positiveButton != null) {
            builder.setPositiveButton(positiveButton, positiveClick)
        }
        if (negativeButton != null) {
            builder.setNegativeButton(negativeButton, negativeClick)
        }
        val alertDialog = builder.create()
        if (setCancelable) {
            alertDialog.setCancelable(true)
        } else {
            alertDialog.setCancelable(false)
        }
        if (!activity.isFinishing) {
            alertDialog.show()
        }
        dialog = alertDialog
        return alertDialog
    }
}