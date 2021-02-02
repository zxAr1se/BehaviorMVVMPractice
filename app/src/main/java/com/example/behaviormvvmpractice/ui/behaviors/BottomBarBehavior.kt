package com.example.behaviormvvmpractice.ui.behaviors

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.math.MathUtils
import androidx.core.view.ViewCompat
import com.example.behaviormvvmpractice.ui.item.BottomBar
import timber.log.Timber

class BottomBarBehavior : CoordinatorLayout.Behavior<BottomBar>() {

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: BottomBar,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: BottomBar,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        val offset = MathUtils.clamp(child.translationY + dy, 0f, child.minimumHeight.toFloat())
        if (offset != child.translationY) child.translationY = offset
        Timber.d("dy: $dy translationY : ${child.translationY}")
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }
}