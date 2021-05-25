package toolkit

import com.github.jershell.kbson.BsonEncoder
import com.github.jershell.kbson.FlexibleDecoder
import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.bson.BsonType
import kotlin.contracts.ExperimentalContracts

/**
 * The serializer for [Instant]
 */
actual object InstantSerializer : DefaultInstantSerializer(), KSerializer<Instant> {

    override fun serialize(encoder: Encoder, value: Instant) {
        when(encoder) {
            is BsonEncoder -> {
                encoder.encodeDateTime(value.toEpochMilliseconds())
            }
            else -> {
                super.serialize(encoder, value)
            }
        }
    }

    @ExperimentalContracts
    override fun deserialize(decoder: Decoder): Instant =
            when (decoder) {
                is FlexibleDecoder -> {
                    Instant.fromEpochMilliseconds(
                            when (decoder.reader.currentBsonType) {
                                BsonType.STRING -> decoder.decodeString().toLong()
                                BsonType.DATE_TIME -> decoder.reader.readDateTime()
                                else -> throw SerializationException("Unsupported ${decoder.reader.currentBsonType} reading date")
                            }
                    )
                }
                else -> super.deserialize(decoder)
            }
}