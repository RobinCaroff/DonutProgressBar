package com.robincaroff.donutprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        donutprogressbar_main.maxProgress = 100f
        donutprogressbar_main.progress = 25f
    }
}
