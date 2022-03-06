package com.github.hanalee.thingsflowtask.extension

import android.content.Context
import android.view.View
import android.widget.Toast


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

fun Context.toToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

