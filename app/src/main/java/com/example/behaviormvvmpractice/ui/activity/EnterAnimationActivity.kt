package com.example.behaviormvvmpractice.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.behaviormvvmpractice.R
import com.example.behaviormvvmpractice.databinding.ActivityEnterAnimationBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class EnterAnimationActivity : AppCompatActivity(R.layout.activity_enter_animation) {

    private lateinit var bind: ActivityEnterAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityEnterAnimationBinding.inflate(layoutInflater)
        setContentView(bind.root)

        loadingMainActivity()
            .delay(3000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
            },
                {
                    Timber.d("Throwable : $it")
                })
    }

    private fun loadingMainActivity(): Single<Class<MainActivity>> {
        return Single.just(MainActivity::class.java)
    }
}