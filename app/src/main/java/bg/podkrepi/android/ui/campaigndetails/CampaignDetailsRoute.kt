package bg.podkrepi.android.ui.campaigndetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import bg.podkrepi.domain.campaigns.Campaign

@Composable
fun CampaignDetailsRoute(
    viewModel: CampaignDetailsViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState.collectAsState()
    uiState.value.campaigns.forEach {
        Campaign(campaign = it)
    }
}

@Composable
fun Campaign(campaign: Campaign) {
    Text(text = campaign.title)
}