package com.example.beagleapp.beagle.httpclient

import com.example.beagleapp.beagle.beaglelogger.BeagleLoggerDefault

internal object BeagleMessageLogs {

    fun logDataNotInsertedOnDatabase(key: String, value: String) {
        BeagleLoggerDefault().warning(
            "Error when trying to insert key=$key with value=$value on Beagle default database."
        )
    }
}