package com.example.behaviormvvmpractice.ui.item


import android.animation.AnimatorSet
import android.animation.ValueAnimator.ofArgb
import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.widget.Button
import android.widget.Checkable
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import com.example.behaviormvvmpractice.R

class CheckableImageView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : AppCompatImageButton(context, attrs, defStyleAttr), Checkable {
    private var checked = false
    private val animation : AnimatorSet

    init {
        val ca = context.getColor(R.color.color_accent)
        val cpd = context.getColor(R.color.color_gray_light)

        val iconAnim = ofArgb(ca, cpd)
        iconAnim.addUpdateListener { foregroundTintList = ColorStateList.valueOf(it.animatedValue as Int) }

        animation = AnimatorSet().apply {
            interpolator = FastOutLinearInInterpolator()
            playTogether(iconAnim)
        }

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