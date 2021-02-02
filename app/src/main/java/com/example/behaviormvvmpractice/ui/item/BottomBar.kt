package com.example.behaviormvvmpractice.ui.item

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.behaviormvvmpractice.R
import com.example.behaviormvvmpractice.databinding.ItemCharacterBinding
import com.example.behaviormvvmpractice.ui.behaviors.BottomBarBehavior
import com.google.android.material.shape.MaterialShapeDrawable

class BottomBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
    ) : ConstraintLayout(context, attrs, defStyleAttr), CoordinatorLayout.AttachedBehavior {


    init {
        View.inflate(context, R.layout.layout_bottombar, this)
        val materialBg = MaterialShapeDrawable.createWithElevationOverlay(context)
        materialBg.elevation = elevation
        background = ContextCompat.getDrawable(context, R.color.color_gray_light)
    }

    override fun getBehavior(): CoordinatorLayout.Behavior<*> {
        return BottomBarBehavior()
    }
}