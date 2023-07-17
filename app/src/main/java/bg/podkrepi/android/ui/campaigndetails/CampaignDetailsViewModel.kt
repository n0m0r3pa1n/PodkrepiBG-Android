package bg.podkrepi.android.ui.campaigndetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bg.podkrepi.domain.campaigns.Campaign
import bg.podkrepi.domain.campaigns.CampaignsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CampaignDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val campaignsRepository: CampaignsRepository
) : ViewModel() {
    init {
        val campaignId = savedStateHandle.get<String>("id")
    }
    val uiStateEmitter = MutableStateFlow(UiState(campaigns = emptyList()))
    val uiState: StateFlow<UiState> = uiStateEmitter

    init {
        viewModelScope.launch {
            uiStateEmitter.emit(UiState(campaignsRepository.getCampaigns()))
        }
    }

    data class UiState(val campaigns: List<Campaign>)
}