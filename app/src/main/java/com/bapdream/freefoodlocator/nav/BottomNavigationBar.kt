package com.bapdream.freefoodlocator.nav

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.navigation.NavHostController
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bapdream.freefoodlocator.R

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        contentColor = Color.Black,
        modifier = Modifier.padding(top=10.dp)
    ) {
        val items = listOf(
            NavigationItem("Locator", R.drawable.locator_icon, "지도로 길찾기"),
            NavigationItem("Direction", R.drawable.direction_icon, "급식소 까지 길찾기"),
            NavigationItem("Main", R.drawable.red_home_icon, "메인 화면"),
            NavigationItem("Like", R.drawable.heart_icon, "관심 급식소 리스트"),
            NavigationItem("FindPolicy", R.drawable.policy_icon, "정책 찾기")
        )

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Image(painterResource(item.icon), contentDescription = item.contentDescription, modifier = Modifier.size(40.dp))
                },
                selected = navController.currentDestination?.route == item.route,
                onClick = {
                    if (navController.currentDestination?.route != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}

data class NavigationItem(
    val route: String,
    @DrawableRes val icon: Int,
    val contentDescription: String
)
