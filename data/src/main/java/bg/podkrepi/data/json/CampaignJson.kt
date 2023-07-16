package bg.podkrepi.data.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CampaignJson(
    @Json(name = "id") val id: String? = null,
    @Json(name = "state") val state: String? = null,
    @Json(name = "slug") val slug: String? = null,
    @Json(name = "title") val title: String? = null,
    @Json(name = "essence") val essence: String? = null,
    @Json(name = "paymentReference") val paymentReference: String? = null,
    @Json(name = "targetAmount") val targetAmount: Int? = null,
    @Json(name = "allowDonationOnComplete") val allowDonationOnComplete: Boolean? = null,
    @Json(name = "currency") val currency: String? = null,
    @Json(name = "startDate") val startDate: String? = null,
    @Json(name = "endDate") val endDate: String? = null,
    @Json(name = "createdAt") val createdAt: String? = null,
    @Json(name = "updatedAt") val updatedAt: String? = null,
    @Json(name = "deletedAt") val deletedAt: String? = null,
    @Json(name = "campaignType") val campaignType: CampaignType? = CampaignType(),
    @Json(name = "beneficiary") val beneficiary: Beneficiary? = Beneficiary(),
    @Json(name = "coordinator") val coordinator: Coordinator? = Coordinator(),
    @Json(name = "organizer") val organizer: Organizer? = Organizer(),
    @Json(name = "campaignFiles") val campaignFiles: List<CampaignFile>? = listOf(),
    @Json(name = "vaults") val vaults: List<Vaults> = listOf(),
    @Json(name = "summary") val summary: Summary? = Summary()
)
