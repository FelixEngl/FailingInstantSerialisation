@file:UseSerializers(InstantSerializer::class)

package data

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import toolkit.InstantSerializer

@Serializable
data class User(
        val name: String,
        val age: Int,
        val createdAd: Instant
)
