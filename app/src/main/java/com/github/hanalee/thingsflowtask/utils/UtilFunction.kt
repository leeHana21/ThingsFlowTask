package com.github.hanalee.thingsflowtask.utils

import android.content.Context
import android.content.DialogInterface
import android.util.Log
import androidx.appcompat.app.AlertDialog
import okhttp3.logging.HttpLoggingInterceptor

class UtilFunction {
    companion object {
        const val TAG = "DEBUG"

        fun httpLoggingInterceptor(): HttpLoggingInterceptor {
            val interceptor =
                HttpLoggingInterceptor { message -> Log.d(TAG, message) }
            return interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        fun showSimpleAlertCheckOnly(
            context: Context,
            msg: String,
            listener: DialogInterface.OnClickListener?
        ) {
            AlertDialog.Builder(context)
                .setTitle("알림")
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("확인", listener)
                .show()
        }
    }
}