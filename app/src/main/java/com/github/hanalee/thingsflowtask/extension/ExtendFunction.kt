package com.github.hanalee.thingsflowtask.extension

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import com.github.hanalee.thingsflowtask.utils.OnThrottleClickListener
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * 확장 함수 정의 파일
 */


/**
 * View Extend Functions
 */
fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.toInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.toGone() {
    this.visibility = View.GONE
}

fun View.toEnable() {
    this.isEnabled = true
}

fun View.toDisable() {
    this.isEnabled = false
}

/**
 * View 중복 클릭 방지
 */
fun View.onThrottleClick(action: (v: View) -> Unit) {
    val listener = View.OnClickListener { action(it) }
    setOnClickListener(OnThrottleClickListener(listener))
}


fun Context.toToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

