package com.bapdream.freefoodlocator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.bapdream.freefoodlocator.nav.BottomNavigationBar
import com.bapdream.freefoodlocator.nav.MainNavHost
import com.bapdream.freefoodlocator.ui.theme.BapDreamTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BapDreamTheme {
                val mainNavController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(mainNavController) // 같은 NavController 사용
                    }
                ) {
                    Box(modifier = Modifier.fillMaxSize()) { // Box를 추가하여 내부에 패딩을 조절합니다.
                        MainNavHost(
                            navController = mainNavController,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(bottom = 70.dp) // BottomNavigationBar의 높이에 맞추어 패딩 설정
                        )
                    }
                }
            }
        }
    }
}

//@Composable
//@Preview(showBackground = true)
//fun PreviewMainScreen() {
//    BapDreamTheme {
//        val mainNavController = rememberNavController()
//        val bottomNavController = rememberNavController()
//
//        Scaffold(
//            modifier = Modifier.fillMaxSize(),
//            bottomBar = {
//                BottomNavigationBar(bottomNavController)
//            }
//        ) {
//            Box(modifier = Modifier.fillMaxSize()) { // Box를 추가하여 내부에 패딩을 조절합니다.
//                MainNavHost(
//                    navController = mainNavController,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(bottom = 56.dp) // BottomNavigationBar의 높이에 맞추어 패딩 설정
//                )
//            }
//        }
//    }
//}