package com.example.dedeepsingu_3200midtermtimers

import com.example.dedeepsingu_3200midtermtimers.timers.MainScreenViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MainScreenViewModelTest {
    private lateinit var viewModel: MainScreenViewModel

    @Before
    fun setUp() {
        viewModel = MainScreenViewModel()
    }

    @Test
    fun testInputTime() {
        viewModel.inputTime.value = "10"
        val time = viewModel.inputTime.value
        Assert.assertEquals("10", time)
    }

    @Test
    fun testIsRunning() {
        viewModel.isRunning.value = true
        val isRunning = viewModel.isRunning.value
        Assert.assertEquals(true, isRunning)

        viewModel.isRunning.value = false
        val isNotRunning = viewModel.isRunning.value
        Assert.assertEquals(false, isNotRunning)
    }

    @Test
    fun testCurrentTime() {
        viewModel.currentTime.intValue = 60000
        val currentTime = viewModel.currentTime.intValue
        Assert.assertEquals(60000, currentTime)

        viewModel.currentTime.intValue = 0
        val resetTime = viewModel.currentTime.intValue
        Assert.assertEquals(0, resetTime)
    }
}