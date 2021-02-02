package com.example.behaviormvvmpractice.ui.behaviors

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.marginEnd
import androidx.core.view.marginRight
import com.example.behaviormvvmpractice.ui.item.ArticleSubmenu
import com.example.behaviormvvmpractice.ui.item.BottomBar
import timber.log.Timber

class SubmenuBehavior : CoordinatorLayout.Behavior<ArticleSubmenu>() {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: ArticleSubmenu,
        dependency: View
    ): Boolean {
        return dependency is BottomBar
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: ArticleSubmenu,
        dependency: View
    ): Boolean {
        return if (child.isOpen && dependency is BottomBar && dependency.translationY >= 0){
            animate(child, dependency)
            true
        }else false
    }

    private fun animate(child: ArticleSubmenu, dependency: BottomBar){
        val fraction = dependency.translationY/dependency.minimumHeight
        Timber.d("fraction: $fraction  translationX: ${child.translationX}")
        child.translationX = (child.width + child.marginRight) * fraction
    }
}