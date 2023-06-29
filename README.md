# Neuro

This repository contains the source code and documentation for an Android application that measures fine motor skills using the gyro sensors available on Android devices. The app provides users with interactive exercises to perform, allowing them to assess and improve their fine motor skills.

## Features
Gyro Sensor Integration: The app utilizes the built-in gyro sensors on Android devices to capture precise motion data for fine motor skills assessment.
Performance Tracking: The app records and displays performance metrics of the performed exercises, to help users track their progress over time.
User Profiles: Users can create personal profiles within the app to save their exercise history, view past performance, and set goals for improvement.
Data Export: Users can export their exercise data to a server for further analysis or sharing with healthcare professionals, therapists, or researchers.

## Getting Started
### Prerequisites
Android Studio: Make sure you have Android Studio installed on your development machine.
Android Device: You will need an Android device or emulator to run and test the app.
A running backend: The repository can be found here: https://github.com/Greg8052/backend

### Installation
Clone this repository to your local machine.
Open the cloned project in Android Studio.
Find out the IP address of the machine running the backend and replace the IP adress in the file `network/ExperimentApiService.kt` with the IP address of your machine.
Connect your Android device to your machine or start an emulator.

Build and run the app from Android Studio to install it on your device or emulator.

### Usage
Upon launching the app, you will be greeted with the options to go to test the connection to your running backend (), or start a new measurement.

Upon starting a measurement, hold the phone in one hand and tap the start button. In the following 5 seconds, do a "unscrew jar"-motion until you hear a bell. Repeat for the other hand. The app will utilize the gyro sensors to track your hand rotation and provide feedback on your performance (not implemented in this POC. The graph is buggy and displays random numbers). You will then have the option to save the data to the running server.

## License
This project is licensed under the MIT License. Feel free to use, modify, and distribute the code as permitted by the license.

Contact
If you have any questions, suggestions, or feedback, please feel free to contact the project maintainer:

Email: gregory.witmer@students.fhnw.com
You can also create an issue in the GitHub repository for bug reports, feature requests, or general discussions.
