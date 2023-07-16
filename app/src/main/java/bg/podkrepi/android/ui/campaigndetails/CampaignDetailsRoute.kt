package bg.podkrepi.android.ui.campaigndetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import bg.podkrepi.android.ui.campaigns.CampaignsViewModel
import bg.podkrepi.domain.campaigns.Campaign

@Composable
fun CampaignDetailsRoute(
    viewModel: CampaignsViewModel = viewModel(),
    onNavigateToDetails: (id: String) -> Unit
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