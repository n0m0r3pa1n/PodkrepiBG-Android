package bg.podkrepi.android

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import bg.podkrepi.android.Destinations.CAMPAIGNS
import bg.podkrepi.android.Destinations.CAMPAIGN_DETAILS
import bg.podkrepi.android.ui.campaigndetails.CampaignDetailsRoute
import bg.podkrepi.android.ui.campaigns.CampaignsRoute

object Destinations {
    const val CAMPAIGNS = "campaigns"
    const val CAMPAIGN_DETAILS = "campaigns/{id}"
}

@Composable
fun PodkrepiNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = CAMPAIGNS,
    ) {
        composable(CAMPAIGNS) {
            CampaignsRoute(
                onNavigateToDetails = {
                    navController.navigate("campaigns/$it")
                },
            )
        }

        composable(CAMPAIGN_DETAILS) {
            val startingEmail = it.arguments?.getString("id")
            CampaignDetailsRoute(
                onNavigateToDetails = {}
            )
        }
    }
}
