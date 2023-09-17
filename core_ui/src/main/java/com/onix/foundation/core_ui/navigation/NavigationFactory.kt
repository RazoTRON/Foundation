package com.onix.foundation.core_ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface NavigationFactory {
    fun create(builder: NavGraphBuilder, navController: NavHostController)
}