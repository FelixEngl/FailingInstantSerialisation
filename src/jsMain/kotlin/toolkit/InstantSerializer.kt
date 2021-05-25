package toolkit

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer

actual object InstantSerializer: DefaultInstantSerializer(), KSerializer<Instant>