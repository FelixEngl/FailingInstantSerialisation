import data.User
import kotlinx.datetime.Instant
import kotlinx.serialization.json.Json

fun main() {
    val x = User("Test", 42, Instant.fromEpochMilliseconds(System.currentTimeMillis()))
    println(Json.encodeToString(User.serializer(), x))
}