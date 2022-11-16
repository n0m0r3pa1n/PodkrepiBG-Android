package bg.podkrepi.data.api

import bg.podkrepi.data.json.CampaignJson
import retrofit2.http.GET

interface PodkrepiBGApi {
    @GET("campaign/list")
    suspend fun getCampaigns(): List<CampaignJson>
}
