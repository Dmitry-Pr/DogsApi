package org.hse.template.client.rest.model

import com.google.gson.Gson
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Lob
import java.time.LocalDateTime

@Entity
data class CachedResponse(
    @Id
    val id: String,

    @Lob
    val response: String,
    val timestamp: LocalDateTime
) {
    fun <T> getResponseAsObject(clazz: Class<T>): T {
        return Gson().fromJson(response, clazz)
    }
}