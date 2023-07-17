package bg.podkrepi.data.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Company(
    @Json(name = "id") var id: String? = null,
    @Json(name = "companyName") val companyName: String? = null
)