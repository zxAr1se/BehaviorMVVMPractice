package com.example.behaviormvvmpractice.ui.item

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.example.behaviormvvmpractice.R
import com.example.behaviormvvmpractice.databinding.LayoutSubmenuBinding
import com.example.behaviormvvmpractice.ui.behaviors.SubmenuBehavior
import com.example.behaviormvvmpractice.extensions.dpToPx
import com.example.behaviormvvmpractice.ui.activity.MainActivity
import com.google.android.material.shape.MaterialShapeDrawable

class ArticleSubmenu @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), CoordinatorLayout.AttachedBehavior{


    override fun getBehavior(): CoordinatorLayout.Behavior<*> {
        return SubmenuBehavior()
    }


    var isOpen = false
    private var counterX: Float = context.dpToPx(220)
    private var counterY: Float = context.dpToPx(-15)

    init {
        View.inflate(context, R.layout.layout_submenu,this)
        val materialBg = MaterialShapeDrawable.createWithElevationOverlay(context)
        materialBg.elevation = elevation
        background = materialBg

    }


    fun open(){
        if (isOpen || !isAttachedToWindow) return
        isOpen = true
        animatedShow()
    }

    fun close(){
        if(!isOpen || !isAttachedToWindow) return
        isOpen = false
        animatedHide()
    }

    private fun animatedShow(){
        this.visibility = View.VISIBLE
        translationX = counterX
        translationY = counterY
    }

    private fun animatedHide() {
        this.visibility = View.INVISIBLE
    }
}