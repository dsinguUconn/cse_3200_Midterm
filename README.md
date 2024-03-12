# cse_3200_Midterm
# Dedeep Singu

*Note: Implementation consists of Timers instead of Stopwatches. This was an acceptable implementation
as checked by Prof. Bradford. Furthermore, no outside resources were used other than the in-class videoed 
lectures and code provided by Prof. Bradford. Furthermore, the reset button allows the user to reset the time
while also allowing them to choose a new time for the timer.

Details of the app:
This application follows the model-view-controller (MVC) pattern for its design. 

1. Model: This represents the application's data and the rules to manipulate that data. In this case, the MainScreenViewModel, LeftScreenViewModel, and RightScreenViewModel classes can be considered as the Model. They hold the state of the application and contain the logic to update the state. 

2. View: This is responsible for rendering the Model's data and providing the user interface. In a Compose application, the composables are the View. In this case, the MainScreen, LeftScreen, and RightScreen composables are the View. They observe the state from the ViewModel and update the UI accordingly.

3. Controller: This handles the user's interactions and updates the Model accordingly. In a Compose application, the ViewModel can also act as the Controller. In this case, the MainScreenViewModel, LeftScreenViewModel, and RightScreenViewModel classes are the Controller. They contain the logic to handle user inputs, such as starting and stopping the timer, and update the Model. These classes are typically located in a controller or viewModel directory.

In order to run the application, simply clone the cse_3200_Midterm repository into your local and run the application.
In case of failures to run, check that all tests pass; if they don't, there is something wrong with your 
dependencies, etc.
