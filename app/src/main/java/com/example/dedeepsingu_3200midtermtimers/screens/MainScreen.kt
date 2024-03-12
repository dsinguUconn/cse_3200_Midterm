package com.example.dedeepsingu_3200midtermtimers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dedeepsingu_3200midtermtimers.timers.MainScreenViewModel
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.dedeepsingu_3200midtermtimers.ui.theme.MyAppTheme
import java.util.concurrent.TimeUnit

fun formatTime(timeInMillis: Long): String {
    val hours = TimeUnit.MILLISECONDS.toHours(timeInMillis)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(timeInMillis) % 60
    val seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis) % 60
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

@Composable
fun MainScreen(navController: NavController, viewModel: MainScreenViewModel) {
    MyAppTheme {
        val rainbowColors = listOf(
            Color.Red,
            Color(0xFFFF7F00),
            Color.Yellow,
            Color.Green,
            Color.Blue,
            Color(0xFFD0BCFF),
            Color(0xFF6650a4)
        )
        val rainbowGradient = Brush.verticalGradient(rainbowColors)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(rainbowGradient),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 50.dp)
            ) {
                val minutes = viewModel.currentTime.intValue / 60
                val seconds = viewModel.currentTime.intValue % 60
                Text("Time remaining: ${formatTime(viewModel.currentTime.intValue.toLong() * 1000)}", style = TextStyle(fontSize = 24.sp))
                if (viewModel.isInputVisible.value) {
                    OutlinedTextField(
                        value = viewModel.inputTime.value,
                        onValueChange = { viewModel.inputTime.value = it },
                        label = { Text("Enter minutes") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }

                Button(onClick = {
                    if (viewModel.isRunning.value) {
                        viewModel.stopTimer()
                    } else {
                        viewModel.startTimer()
                    }
                }) {
                    Text(if (viewModel.isRunning.value) "Stop Timer" else "Start Timer")
                }

                if (viewModel.timeUp.value) {
                    Text("TIME IS UP!")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = { viewModel.resetTimer() }) {
                    Text("Reset Timer")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        navController.navigate(ScreenRoutes.LeftScreen.route)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("LEFT screen")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        navController.navigate(ScreenRoutes.RightScreen.route)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("RIGHT screen")
                }
            }
        }
    }

}