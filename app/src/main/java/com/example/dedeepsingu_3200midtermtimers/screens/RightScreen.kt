package com.example.dedeepsingu_3200midtermtimers.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.dedeepsingu_3200midtermtimers.timers.RightScreenViewModel
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dedeepsingu_3200midtermtimers.ui.theme.MyAppTheme

@Composable
fun RightScreen(navController: NavController, viewModel: RightScreenViewModel) {
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
            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 50.dp)){
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

                if (viewModel.isRunning.value) {
                    Button(onClick = { viewModel.pauseTimer() }) {
                        Text("Stop Timer")
                    }
                } else {
                    Button(onClick = { viewModel.startTimer() }) {
                        Text("Start Timer")
                    }
                }

                if (viewModel.timeUp.value) {
                    Text("TIME IS UP!")
                }
                Button(onClick = { viewModel.resetTimer() }) {
                    Text("Reset Timer")
                }

                Button(onClick = { navController.navigate(ScreenRoutes.MainScreen.route) }) {
                    Text("Go to Main Screen")
                }

                Button(onClick = { navController.navigate(ScreenRoutes.LeftScreen.route) }) {
                    Text("Go to Left Screen")
                }
            }
        }
    }
}