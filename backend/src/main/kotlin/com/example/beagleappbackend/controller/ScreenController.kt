package com.example.beagleappbackend.controller

import com.example.beagleappbackend.service.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ScreenController(
        private val simpleScreenService: SimpleScreenService,
        private val navigationScreenService: NavigationScreenService,
        private val clickActionScreenService: ClickActionScreenService,
        private val contextScreenService: ContextScreenService,
        private val singleComponentService: SingleComponentService
) {

    @GetMapping("/simple/screen")
    fun getSimpleScreen() = simpleScreenService.createdSimpleScreen()

    @GetMapping("/click/screen")
    fun getClickScreen() = clickActionScreenService.createdClickScreen()

    @GetMapping("/navigation/screen")
    fun getNavigationScreen() = navigationScreenService.createdNavigationScreen()

    @GetMapping("/context/screen")
    fun getContextScreen() = contextScreenService.createdContextScreen()

    @GetMapping("/single/component")
    fun getServerDrivenComponent() = singleComponentService.createServerDrivenComponent()
}