package com.example.beagleappbackend.builder

import br.com.zup.beagle.annotation.BeaglePreview
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Text

@BeaglePreview
fun buildPreview() = PreviewScreenBuilder()

class PreviewScreenBuilder: ScreenBuilder {
    override fun build() = Screen(
            navigationBar = NavigationBar(
                    title = "Beagle Preview",
                    showBackButton = true
            ),
            child = Container(
                    children = listOf(
                            beagleText(text = "hello world 1", appearanceColor = "#D81B60"),
                            beagleText(text = "hello world 2", appearanceColor = "#1b2534"),
                            beagleText(text = "hello world 3", appearanceColor = "#6F6F6F"),
                            beagleText(text = "hello world 4",  appearanceColor = "#008577")
                    )
            )
    )

    private fun beagleText(
            text: String,
            appearanceColor: String? = null
    ) =
            Text(text = text, styleId = "DesignSystem.Text.Description")
                    .applyStyle(Style(
                            backgroundColor = appearanceColor,
                            margin = EdgeValue(
                                    top = 16.unitReal(),
                                    left = 16.unitReal(),
                                    right = 16.unitReal()
                            )
                    )
                    )
}