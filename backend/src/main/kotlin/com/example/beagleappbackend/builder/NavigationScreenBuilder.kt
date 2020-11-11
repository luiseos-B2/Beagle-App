package com.example.beagleappbackend.builder

import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.action.Action
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button

class NavigationScreenBuilder: ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                navigationBar = NavigationBar(
                        title = "Navigation Screen",
                        showBackButton = true,
                        styleId = "DesignSystem.Toolbar.Center"
                ),
                child = Container(
                        children = listOf(
                                createButton(
                                        text = "Navigation screen server driven",
                                        onPress = listOf(
                                                Navigate.PushView(
                                                        Route.Remote(
                                                                url = "/click/screen",
                                                                shouldPrefetch =  true
                                                        )
                                                )
                                        )
                                ),
                                createButton(
                                        text = "Navigation screen native",
                                        onPress = listOf(
                                                Navigate.OpenNativeRoute(
                                                        route = "screen-native",
                                                        shouldResetApplication = false
                                                )
                                        )
                                )

                        )
                )
        )
    }

    private fun createButton(
            text: String,
            onPress: List<Action>
    ): Widget {
        return Button(
                text = text,
                styleId = "DesignSystem.Button.Screen",
                onPress = onPress
        ).applyStyle(
                Style(
                        margin = EdgeValue(horizontal = 15.unitReal(), top = 10.unitReal())
                )
        )
    }
}