package com.example.beagleappbackend.builder

import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.widget.core.AlignItems
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Text

class ClickActionScreenBuilder : ScreenBuilder {
    override fun build() = Screen(
            navigationBar = NavigationBar(
                    title = "Action Click",
                    showBackButton = true
            ),
            child = Text(
                    text = "You clicked right",
                    styleId = "DesignSystem.Text.Title"
            ).applyFlex(
                    flex = Flex(
                            justifyContent = JustifyContent.CENTER,
                            alignItems = AlignItems.CENTER
                    )
            )
    )
}