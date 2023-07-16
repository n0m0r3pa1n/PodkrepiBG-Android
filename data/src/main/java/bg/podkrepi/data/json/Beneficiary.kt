package bg.podkrepi.data.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Beneficiary(
    @Json(name = "id") val id: String? = null,
    @Json(name = "type") val type: String? = null,
    @Json(name = "publicData") val publicData: String? = null,
    @Json(name = "person") val person: Person? = Person(),
    @Json(name = "company") val company: String? = null
)