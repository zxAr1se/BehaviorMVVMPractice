package com.example.behaviormvvmpractice.extensions

import android.content.Context
import android.util.TypedValue

fun Context.dpToPx(dp: Int): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        this.resources.displayMetrics
    )
}