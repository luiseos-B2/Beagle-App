package com.example.beagleapp.beagle.storehandler

import br.com.zup.beagle.android.store.LocalStore

internal object MemoryLocalStore : LocalStore {

    private val cache = mutableMapOf<String, String>()

    override fun save(key: String, value: String) {
        cache[key] = value
    }

    override fun restore(key: String): String? {
        return cache[key]
    }

    override fun delete(key: String) {
        cache.remove(key)
    }

    override fun getAll(): Map<String, String> {
        return cache.toMap()
    }
}