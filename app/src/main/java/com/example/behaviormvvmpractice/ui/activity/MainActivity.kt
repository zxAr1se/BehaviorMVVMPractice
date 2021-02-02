package com.example.behaviormvvmpractice.ui.activity

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Checkable
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.get
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import com.example.behaviormvvmpractice.R
import com.example.behaviormvvmpractice.databinding.ActivityMainBinding
import com.example.behaviormvvmpractice.extensions.init
import www.sanju.motiontoast.MotionToast

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val WARNING_REQUEST_TITLE_TOAST = "Warning"
        const val WARNING_REQUEST_MSG_TOAST = "May be next time ?"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomBar()
        setupFabs()
        fabsListener()
    }


    private fun setupFabs(){
        binding.apply {
            charactersFab.init(-210f, -130f)
            comicsFab.init(0f,110f)
            eventsFab.init(210f, -130f)
        }



        binding.fab.setOnClickListener {
            if (binding.charactersFab.isOrWillBeShown) binding.charactersFab.hide() else binding. charactersFab.show()
            if (binding.comicsFab.isOrWillBeShown) binding.comicsFab.hide() else binding.comicsFab.show()
            if (binding.eventsFab.isOrWillBeShown) binding.eventsFab.hide() else binding.eventsFab.show()
        }
    }


    private fun setupBottomBar(){
        binding.btnNightMode.setOnClickListener {
            it as Checkable
            it.toggle()
            if(it.isChecked) binding.submenu.open() else binding.submenu.close()
        }
    }

    private fun fabsListener(){
        binding.charactersFab.setOnClickListener {
            MotionToast.createToast(
                this,
                WARNING_REQUEST_TITLE_TOAST,
                WARNING_REQUEST_MSG_TOAST,
                MotionToast.TOAST_WARNING,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular)
            )
            }

        binding.comicsFab.setOnClickListener {

                MotionToast.createToast(
                this,
                WARNING_REQUEST_TITLE_TOAST,
                WARNING_REQUEST_MSG_TOAST,
                MotionToast.TOAST_WARNING,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular)
                )
            }

        binding.eventsFab.setOnClickListener {
            MotionToast.createToast(
                this,
                WARNING_REQUEST_TITLE_TOAST,
                WARNING_REQUEST_MSG_TOAST,
                MotionToast.TOAST_WARNING,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular)
            )
        }
    }


}