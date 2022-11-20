package com.example.dognavigationexample.presentation.start

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dognavigationexample.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun StartScreen(navController: NavController) {

    val scope= rememberCoroutineScope()

    var animated by remember { mutableStateOf(1f) }
    val and by animateFloatAsState(
        targetValue = animated,
        animationSpec = tween(1000)
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth(and)
                .padding(horizontal = 40.dp)
                .shadow(4.dp),
            backgroundColor = Color.LightGray
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 24.dp)
            ) {
                Button(onClick = {
                    scope.launch {
                        animated = 0f
                        delay(700)
                        navController.navigate(
                            Screen.List.takeId("go_to_AnimatedVisibility")
                        )
                    }
                }) {
                    Text(
                        text = "AnimatedVisibility",
                        fontSize = 22.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {
                    navController.navigate(
                        Screen.List.takeId("go_to_ListWithDetailFragment")
                    )
                }) {
                    Text(
                        text = "ListWithDetailFragment",
                        fontSize = 22.sp
                    )
                }
            }
        }
    }
}