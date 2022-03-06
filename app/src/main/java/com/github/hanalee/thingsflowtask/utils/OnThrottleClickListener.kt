package com.github.hanalee.thingsflowtask.utils

import android.util.Log
import android.view.View

/**
 * 중복 클릭 방지 class
 */
class OnThrottleClickListener(
    private val clickListener: View.OnClickListener,
    private val interval: Long = 400
) : View.OnClickListener {
    private val TAG = "Throttle_Click"
    private var clickable = true
    override fun onClick(v: View?) {
        if (clickable) {
            clickable = false
            v?.run {
                postDelayed({ clickable = true }, interval)
                clickListener.onClick(v)
            }
        } else {
            Log.d(TAG, "waiting for a while")
        }
    }
}