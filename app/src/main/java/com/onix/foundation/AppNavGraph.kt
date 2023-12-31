package com.onix.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.onix.foundation.core_ui.navigation.NavigationFactory

@Composable
fun AppNavGraph(
    modifier: Modifier,
    navController: NavHostController,
    navigationFactories: Set<NavigationFactory>,
    startDestination: String
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        navigationFactories.forEach {
            it.create(this, navController)
        }
    }
}