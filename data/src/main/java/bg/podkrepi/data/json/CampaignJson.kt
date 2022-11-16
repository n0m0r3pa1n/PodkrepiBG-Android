package bg.podkrepi.data.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CampaignJson(
    @Json(name = "title")
    val title: String
)
