package com.example.dedeepsingu_3200midtermtimers.timers

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainScreenViewModel : ViewModel() {
    val inputTime = mutableStateOf("")
    val currentTime = mutableIntStateOf(0)
    val timeUp = mutableStateOf(false)
    val isRunning = mutableStateOf(false)
    private var job: Job? = null
    val isInputVisible = mutableStateOf(true)

    fun startTimer() {
        if (!isRunning.value && currentTime.intValue == 0) {
            val time = inputTime.value.toIntOrNull() ?: 0
            currentTime.intValue = time * 60
            isInputVisible.value = false
        }
        isRunning.value = true

        job = viewModelScope.launch {
            while (currentTime.intValue > 0) {
                delay(1000)
                currentTime.intValue--
            }
            timeUp.value = true
            isRunning.value = false
        }
    }
    fun stopTimer() {
        job?.cancel()
        isRunning.value = false
    }

    fun resetTimer() {
        job?.cancel()
        currentTime.intValue = 0
        timeUp.value = false
        isRunning.value = false
        isInputVisible.value = true
    }
}