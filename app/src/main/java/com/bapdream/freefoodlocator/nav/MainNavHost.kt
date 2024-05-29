package com.bapdream.freefoodlocator.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bapdream.freefoodlocator.ui.DirectionsScreen
import com.bapdream.freefoodlocator.ui.FindPolicyScreen
import com.bapdream.freefoodlocator.ui.LikesScreen
import com.bapdream.freefoodlocator.ui.LocatorScreen
import com.bapdream.freefoodlocator.ui.MainScreen

@Composable
fun MainNavHost(navController: NavHostController,modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = "Main",
        modifier=modifier
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