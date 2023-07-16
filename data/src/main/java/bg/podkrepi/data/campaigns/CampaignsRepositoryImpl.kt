package bg.podkrepi.data.campaigns

import bg.podkrepi.data.api.PodkrepiBGApi
import bg.podkrepi.data.json.CampaignJson
import bg.podkrepi.domain.campaigns.Campaign
import bg.podkrepi.domain.campaigns.CampaignsRepository
import javax.inject.Inject

class CampaignsRepositoryImpl @Inject constructor(
    private val podkrepiBGApi: PodkrepiBGApi
) : CampaignsRepository {
    override suspend fun getCampaigns(): List<Campaign> {
        return podkrepiBGApi.getCampaigns().map { it.toCampaign() }
    }

    private fun CampaignJson.toCampaign() = Campaign(
        title = title ?: ""
    )
}
