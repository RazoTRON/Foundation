package com.onix.foundation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.onix.foundation.core_ui.navigation.NavigationFactory
import com.onix.foundation.core_ui.theme.FoundationTheme
import com.onix.foundation.home_api.HomeFeatureRoutes
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationFactories: @JvmSuppressWildcards Set<NavigationFactory>

    @Inject
    lateinit var homeFeatureRoutes: HomeFeatureRoutes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            FoundationTheme {
                Scaffold {
                    AppNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(it),
                        navigationFactories = navigationFactories,
                        startDestination = homeFeatureRoutes.homeRoute
                    )
                }
            }
        }
    }
}