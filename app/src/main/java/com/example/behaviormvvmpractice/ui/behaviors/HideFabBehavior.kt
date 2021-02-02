package com.example.behaviormvvmpractice.ui.behaviors

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.behaviormvvmpractice.ui.item.CustomFab
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HideFabBehavior() : CoordinatorLayout.Behavior<FloatingActionButton>() {
    constructor(ctx: Context, attrs: AttributeSet) : this()

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: FloatingActionButton,
        dependency: View
    ): Boolean {
        dependency as CustomFab
        return if (dependency.isChecked && dependency.isOrWillBeHidden) {child.hide(); true}
        else if (dependency.isChecked) {child.show(); true}
        else false
    }
}