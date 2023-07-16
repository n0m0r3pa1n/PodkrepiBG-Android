package bg.podkrepi.android.ui.campaigns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import bg.podkrepi.domain.campaigns.Campaign

@Composable
fun CampaignsRoute(
    viewModel: CampaignsViewModel = hiltViewModel(),
    onNavigateToDetails: (id: String) -> Unit
) {
    val uiState = viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        uiState.value.campaigns.forEach {
            Campaign(campaign = it)
        }
    }
}

@Composable
fun Campaign(campaign: Campaign) {

    Row {
        Text(text = campaign.title)
    }
}