package bg.podkrepi.android.ui.campaigns

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import bg.podkrepi.domain.campaigns.Campaign

@Composable
fun CampaignsRoute(
    viewModel: CampaignsViewModel = hiltViewModel(),
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