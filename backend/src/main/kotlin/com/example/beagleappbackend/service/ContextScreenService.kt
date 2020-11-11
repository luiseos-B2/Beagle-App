package com.example.beagleappbackend.service

import com.example.beagleappbackend.builder.ContextScreenBuilder
import org.springframework.stereotype.Service

@Service
class ContextScreenService {
    fun createdContextScreen() = ContextScreenBuilder()
}