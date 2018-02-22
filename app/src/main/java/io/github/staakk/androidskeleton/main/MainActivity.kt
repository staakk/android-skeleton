package io.github.staakk.androidskeleton.main

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.github.staakk.androidskeleton.R

class MainActivity : DaggerAppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
