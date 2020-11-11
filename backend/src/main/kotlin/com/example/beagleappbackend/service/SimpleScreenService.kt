package com.example.beagleappbackend.service

import com.example.beagleappbackend.builder.SimpleScreenBuilder
import org.springframework.stereotype.Service

@Service
class SimpleScreenService {
    fun createdSimpleScreen() = SimpleScreenBuilder()
}