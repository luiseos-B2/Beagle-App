package com.example.beagleappbackend.service

import com.example.beagleappbackend.builder.NavigationScreenBuilder
import org.springframework.stereotype.Service

@Service
class NavigationScreenService {
    fun createdNavigationScreen() = NavigationScreenBuilder()
}