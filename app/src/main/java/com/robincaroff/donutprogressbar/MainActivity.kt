package com.robincaroff.donutprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        donutprogressbar_main.maxProgress = PROGRESS_TARGET

        updateProgress()
    }

    private fun updateProgress() {
        Handler().postDelayed( {
            if(donutprogressbar_main.progress < PROGRESS_TARGET) {
                donutprogressbar_main.progress++
                updateProgress()
            }
        }, UPDATE_DELAY_MILLISECONDS)
    }

    companion object {
        private const val PROGRESS_TARGET = 100f
        private const val UPDATE_DELAY_MILLISECONDS = 100L
    }

}
