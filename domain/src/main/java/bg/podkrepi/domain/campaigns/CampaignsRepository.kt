package bg.podkrepi.domain.campaigns

interface CampaignsRepository  {
    suspend fun getCampaigns(): List<Campaign>
}
