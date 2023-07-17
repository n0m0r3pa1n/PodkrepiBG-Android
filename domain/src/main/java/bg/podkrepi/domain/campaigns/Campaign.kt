package bg.podkrepi.domain.campaigns

data class Campaign(
    val id: String,
    val title: String,
    val campaignImageUrl: String? = null
)
