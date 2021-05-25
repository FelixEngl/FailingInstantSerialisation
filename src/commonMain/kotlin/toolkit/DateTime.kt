package toolkit

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.contracts.ExperimentalContracts

@RequiresOptIn(message = "This API is experimental. It may be changed in the future without notice.", level = RequiresOptIn.Level.WARNING)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DateTimeWorkaround

@Serializer(forClass = Instant::class)
@DateTimeWorkaround
expect object InstantSerializer : KSerializer<Instant>

@DateTimeWorkaround
abstract class DefaultInstantSerializer : KSerializer<Instant> {
    override val descriptor = PrimitiveSerialDescriptor("InstantEpochMilliSeconds", PrimitiveKind.LONG)

    override fun serialize(encoder: Encoder, value: Instant) {
        encoder.encodeLong(value.toEpochMilliseconds())
    }

    @ExperimentalContracts
    override fun deserialize(decoder: Decoder): Instant =
            Instant.fromEpochMilliseconds(decoder.decodeLong())

}