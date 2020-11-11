package com.example.beagleapp.view.activity

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.android.utils.loadView
import br.com.zup.beagle.android.view.ScreenRequest
import com.example.beagleapp.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        componentServerDriven()

    }

    private fun componentServerDriven(){
        val frameLayout = findViewById<FrameLayout>(R.id.fr_server_driven)
        frameLayout.loadView(this, ScreenRequest("/single/component"))
    }
}