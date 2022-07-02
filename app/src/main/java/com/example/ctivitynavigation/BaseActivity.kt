package com.example.ctivitynavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}