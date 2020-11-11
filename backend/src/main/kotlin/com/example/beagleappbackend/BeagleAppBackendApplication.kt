package com.example.beagleappbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BeagleAppBackendApplication

fun main(args: Array<String>) {
	runApplication<BeagleAppBackendApplication>(*args)
}
