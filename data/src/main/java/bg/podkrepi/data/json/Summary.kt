package bg.podkrepi.data.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Summary(
    @Json(name = "reachedAmount") val reachedAmount: Int? = null,
    @Json(name = "currentAmount") val currentAmount: Int? = null,
    @Json(name = "blockedAmount") val blockedAmount: Int? = null,
    @Json(name = "withdrawnAmount") val withdrawnAmount: Int? = null,
    @Json(name = "donors") val donors: Int? = null
)