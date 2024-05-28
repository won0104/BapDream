package com.bapdream.freefoodlocator.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bapdream.freefoodlocator.ui.DirectionsScreen
import com.bapdream.freefoodlocator.ui.FindPolicyScreen
import com.bapdream.freefoodlocator.ui.LikesScreen
import com.bapdream.freefoodlocator.ui.LocatorScreen
import com.bapdream.freefoodlocator.ui.MainScreen

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "Main",
    ){
        composable(route = "Main"){
            MainScreen(navController)
        }
        composable(route = "FindPolicy"){
            FindPolicyScreen()
        }
        composable(route = "Like"){
            LikesScreen()
        }
        composable(route = "Locator"){
            LocatorScreen()
        }
        composable(route = "Direction"){
            DirectionsScreen()
        }
    }
}