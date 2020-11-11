package com.example.beagleappbackend.service

import com.example.beagleappbackend.builder.SingleComponentBuilder
import org.springframework.stereotype.Service

@Service
class SingleComponentService() {
    fun createServerDrivenComponent() = SingleComponentBuilder().createButton()
}