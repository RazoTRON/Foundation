package com.onix.foundation.home.api

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.onix.foundation.core_ui.navigation.NavigationFactory
import com.onix.foundation.details_api.DetailsFeatureRoutes
import com.onix.foundation.home.ui.HomeScreen
import com.onix.foundation.home_api.HomeFeatureRoutes

class HomeNavigationImpl(
    private val detailsFeatureRoutes: DetailsFeatureRoutes,
) : HomeFeatureRoutes, NavigationFactory {

    override val homeRoute = "home_graph"

    override fun create(builder: NavGraphBuilder, navController: NavHostController) {
        builder.composable(homeRoute) {
            HomeScreen(
                onContactClick = { contactId ->
                    navController.navigate(detailsFeatureRoutes.detailsRoute(contactId))
                }
            )
        }
    }
}