package bg.podkrepi.data.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CampaignType(
    @Json(name = "slug") val slug: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "category") val category: String? = null
)