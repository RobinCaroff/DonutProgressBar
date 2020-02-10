package com.robincaroff.donutprogressbar

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : ScopedAppActivity() {

    private val startingTime = Date().time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        donutprogressbar_main.maxProgress = PROGRESS_TARGET

        updateProgress()
    }

    private fun updateProgress() {
        launch {
            withContext(Dispatchers.Default) {
                delay(UPDATE_DELAY_MILLISECONDS)

                val elapsedSeconds = TimeUnit.MILLISECONDS.toSeconds(Date().time - startingTime)
                withContext(Dispatchers.Main) {
                    if (donutprogressbar_main.progress < PROGRESS_TARGET) {
                        donutprogressbar_main.progress = elapsedSeconds.toFloat()
                        updateProgress()
                    }
                }
            }
        }
    }

    companion object {
        private const val PROGRESS_TARGET = 100f
        private const val UPDATE_DELAY_MILLISECONDS = 100L
    }

}
