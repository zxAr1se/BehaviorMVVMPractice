package com.example.behaviormvvmpractice.ui.item

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.widget.Checkable
import androidx.core.content.ContextCompat
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.example.behaviormvvmpractice.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CustomFab @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
    ) : FloatingActionButton(context, attrs, defStyleAttr), Checkable {
        private var checked = false
        private val animation : AnimatorSet

    init {
        val ca = ContextCompat.getColor(context,R.color.color_accent_dark)
        val cw = ContextCompat.getColor(context, R.color.color_gray_light)

        val rotateAnim = ObjectAnimator.ofFloat(this, "rotation", 135f)

        val iconAnim = ValueAnimator.ofArgb(ca, cw)
        iconAnim.addUpdateListener { imageTintList = ColorStateList.valueOf(it.animatedValue as Int)}
        val bgAnim = ValueAnimator.ofArgb(ca, cw)
        bgAnim.addUpdateListener { imageTintList = ColorStateList.valueOf(it.animatedValue as Int)}

        animation = AnimatorSet().apply {
            interpolator = FastOutSlowInInterpolator()
            playTogether(rotateAnim, bgAnim, iconAnim)
        }
    }

    override fun performClick(): Boolean {
        toggle()
        return super.performClick()
    }

    override fun setChecked(check: Boolean) {
        if (checked == check) return
        checked = check
        playAnimation()
    }

    override fun isChecked(): Boolean = checked

    override fun toggle() {
        isChecked = !checked
    }

    private fun playAnimation(){
        if (isChecked) animation.start() else animation.reverse()
    }
}