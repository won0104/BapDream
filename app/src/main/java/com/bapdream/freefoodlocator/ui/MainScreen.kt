package com.bapdream.freefoodlocator.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bapdream.freefoodlocator.R
import com.bapdream.freefoodlocator.ui.theme.BapDreamTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(navController: NavHostController) {
    val textColor = Color(0xFFF04438)
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .size(460.dp, 270.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "밥드림 메인 로고"
        )
        Column(Modifier.padding(20.dp, 0.dp)) {
            Row {
                // 지도에서 급식소 찾기
                val locatorTitle = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = textColor)) {
                        append("지도")
                    }
                    append("에서\n급식소 찾기 ")
                }
                BottomIconBox(
                    title = locatorTitle,
                    iconResId = R.drawable.locator_icon,
                    iconDescription = "지도 찾기 아이콘",
                    onClick = { navController.navigate("Locator") }
                )
                Spacer(modifier = Modifier.width(20.dp))
                // 급식소 즐겨찾기
                val likesTitle = buildAnnotatedString {
                    append("급식소 ")
                    withStyle(style = SpanStyle(color = textColor)) {
                        append("\n즐겨찾기")
                    }
                }
                BottomIconBox(
                    title = likesTitle,
                    iconResId = R.drawable.heart_icon,
                    iconDescription = "즐겨찾기 리스트 아이콘",
                    onClick = { navController.navigate("Like") }
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                // 급식소까지 길 찾기
                val directionsTitle = buildAnnotatedString {
                    append(" 급식소까지\n")
                    withStyle(style = SpanStyle(color = textColor)) {
                        append("길 찾기")
                    }

                }
                // 다른 정책 찾아보기
                val policyTitle = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = textColor)) {
                        append("다른 정책")
                    }
                    append("\n찾아보기")
                }

                TopIconBox(
                    directionsTitle,
                    R.drawable.direction_icon,
                    "길찾기 아이콘",
                    onClick = { navController.navigate("Direction") })
                Spacer(modifier = Modifier.width(20.dp))
                TopIconBox(
                    policyTitle,
                    R.drawable.policy_icon,
                    "다른 정책 찾기 아이콘",
                    onClick = { navController.navigate("FindPolicy") })
            }

        }
    }
}

@Composable
fun TopIconBox(
    title: AnnotatedString,
    @DrawableRes iconResId: Int,
    iconDescription: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(170.dp, 220.dp)
            .shadow(5.dp, RoundedCornerShape(20.dp)) // 여기서 그림자를 적용
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp), // elevation은 Dp 단위로 설정
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title, modifier = Modifier,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = iconDescription,
                modifier = Modifier
                    .size(70.dp),
            )
        }
    }
}

@Composable
fun BottomIconBox(
    title: AnnotatedString,
    @DrawableRes iconResId: Int,
    iconDescription: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(170.dp, 220.dp)
            .shadow(5.dp, RoundedCornerShape(20.dp)) // 여기서 그림자를 적용
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp), // elevation은 Dp 단위로 설정
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = iconDescription,
                modifier = Modifier
                    .size(70.dp),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = title, modifier = Modifier,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewMainScreen() {
    BapDreamTheme {
        val navController = rememberNavController()
        Box(modifier = Modifier.background(Color(0xFFEED9DF))) {
            MainScreen(navController)
        }
    }
}



