package com.example.beagleappbackend.builder

import br.com.zup.beagle.widget.action.Alert
import br.com.zup.beagle.widget.ui.Button

class SingleComponentBuilder() {

    fun createButton(): Button {
        return Button(
                text = "Sou um botão server-driven",
                onPress = listOf(
                        Alert(
                                title = "Botão server-driven",
                                message = "Sou um botão server-driven",
                                labelOk = "OK"
                        )
                )
        )
    }
}