package com.brfdev.feature1.base

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.brfdev.feature1.R

class ProgressUtil(val activity: Activity?) {

    private lateinit var mAlertDialog: AlertDialog

    @SuppressLint("InflateParams")
    fun showProgress() {
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater.from(activity).inflate(R.layout.view_progress, null)
        //AlertDialogBuilder
        val mBuilder = activity?.let {
            AlertDialog.Builder(it)
                .setView(mDialogView)
                .setCancelable(false)
        }
        //show dialog
        if (mBuilder != null)
            mAlertDialog = mBuilder.show()
        if (mAlertDialog.window != null)
            mAlertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

    fun hideProgress() {
        if (::mAlertDialog.isInitialized) {
            mAlertDialog.dismiss()
        }
    }
}