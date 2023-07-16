package bg.podkrepi.data.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Organizer(
    @Json(name = "id") val id: String? = null,
    @Json(name = "person") val person: Person? = Person()
)