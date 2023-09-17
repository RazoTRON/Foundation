package com.onix.foundation.details.api

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import com.onix.foundation.core_ui.navigation.NavigationFactory
import com.onix.foundation.core_ui.util.injectViewModel
import com.onix.foundation.details.ui.DetailsScreen
import com.onix.foundation.details.ui.DetailsViewModel
import com.onix.foundation.details_api.DetailsFeatureRoutes

internal class DetailsNavigationImpl(
    private val viewModelAssistedFactory: DetailsViewModel.Factory,
) : DetailsFeatureRoutes, NavigationFactory {

    private val mainRoute = "details_graph"

    private val contactIdArgKey = "contactIdArgKey"

    override fun detailsRoute(contactId: String): String {
        return "$mainRoute/$contactId"
    }

    override fun create(builder: NavGraphBuilder, navController: NavHostController) {
        builder.dialog(
            route = "$mainRoute/{$contactIdArgKey}",
            arguments = listOf(navArgument(contactIdArgKey) {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->

            val arguments = requireNotNull(navBackStackEntry.arguments)
            val contactId = requireNotNull(arguments.getString(contactIdArgKey))

            DetailsScreen(
                viewModel = injectViewModel {
                    viewModelAssistedFactory.create(contactId)
                }
            )
        }
    }
}