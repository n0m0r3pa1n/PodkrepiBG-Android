package bg.podkrepi.data.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CampaignFile(
    @Json(name = "id") val id: String? = null,
    @Json(name = "filename") val filename: String? = null,
    @Json(name = "role") val role: String? = null,
)