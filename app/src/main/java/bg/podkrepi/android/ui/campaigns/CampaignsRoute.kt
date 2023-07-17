package bg.podkrepi.android.ui.campaigns

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import bg.podkrepi.android.R
import bg.podkrepi.domain.campaigns.Campaign
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun CampaignsRoute(
    viewModel: CampaignsViewModel = hiltViewModel(),
    onNavigateToDetails: (id: String) -> Unit
) {
    val uiState = viewModel.uiState.collectAsState()
    val lazyListState = rememberLazyListState()
    CampaignLazyColumn(
        campaigns = uiState.value.campaigns,
        lazyScrollState = lazyListState,
        onNavigateToDetails = onNavigateToDetails
    )
}

@Composable
fun CampaignLazyColumn(
    campaigns: List<Campaign>,
    lazyScrollState: LazyListState,
    onNavigateToDetails: (id: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        state = lazyScrollState
    ) {
        items(campaigns, key = { it.id }) {
            CampaignRow(it, onNavigateToDetails)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CampaignRow(campaign: Campaign, onCampaignClick: (id: String) -> Unit) {
    GlideImage(
        model = campaign.campaignImageUrl,
        contentDescription = stringResource(R.string.campaign_picture),
        modifier = Modifier
            .padding(12.dp)
            .clickable(onClick = { onCampaignClick(campaign.id) })
            .wrapContentSize(),
    )
    Text(text = campaign.title)
}