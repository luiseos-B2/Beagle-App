package com.example.beagleapp.beagle.httpclient

import java.lang.Exception
import java.net.HttpURLConnection

internal fun HttpURLConnection.getSafeResponseCode(): Int? {
    return getMessageFormatted { this.responseCode }
}

internal fun HttpURLConnection.getSafeResponseMessage(): String? {
    return getMessageFormatted { this.responseMessage }
}

internal fun HttpURLConnection.getSafeError(): ByteArray? {
    return getMessageFormatted { this.errorStream.readBytes() }
}

internal typealias GetData<T> = () -> T

internal fun <T> getMessageFormatted(getData: GetData<T>): T? {
    return try {
        getData.invoke()
    } catch (exception: Exception) {
        null
    }
}