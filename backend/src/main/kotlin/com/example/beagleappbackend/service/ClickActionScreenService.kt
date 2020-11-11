package com.example.beagleappbackend.service

import com.example.beagleappbackend.builder.ClickActionScreenBuilder
import org.springframework.stereotype.Service

@Service
class ClickActionScreenService {

    fun createdClickScreen() = ClickActionScreenBuilder()

}