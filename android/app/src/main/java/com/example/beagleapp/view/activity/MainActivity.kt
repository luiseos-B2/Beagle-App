package com.example.beagleapp.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.zup.beagle.android.preview.PreviewActivity
import br.com.zup.beagle.android.utils.newServerDrivenIntent
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.android.view.ServerDrivenActivity
import com.example.beagleapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpleScreenButton()
        navigationScreenButton()
        contextScreenButton()
        componentServerDriven()
        previewScreen()

    }

    private fun simpleScreenButton(){
        val simpleScreen = findViewById<Button>(R.id.btn_simple_beagle)
        simpleScreen.setOnClickListener {
            startActivity(
                newServerDrivenIntent<ServerDrivenActivity>(
                    ScreenRequest("/simple/screen")
                )
            )
        }
    }

    private fun navigationScreenButton(){
        val navigationScreen = findViewById<Button>(R.id.btn_navigation_beagle)
        navigationScreen.setOnClickListener {
            startActivity(
                newServerDrivenIntent<ServerDrivenActivity>(
                    ScreenRequest("/navigation/screen")
                )
            )
        }
    }

    private fun contextScreenButton(){
        val contextScreen = findViewById<Button>(R.id.btn_context_beagle)
        contextScreen.setOnClickListener {
            startActivity(
                newServerDrivenIntent<ServerDrivenActivity>(
                    ScreenRequest(url = "/context/screen")
                )
            )
        }
    }

    private fun componentServerDriven() {
        val componentServerDriven = findViewById<Button>(R.id.btn_screen_native_beagle)
        componentServerDriven.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun previewScreen(){
        startActivity(PreviewActivity.newIntent(this))
    }
}