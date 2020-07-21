
# Cat-liker

Cat-liker is an Android app which displays random cute cat pictures to the user.

## Setup

##### Import
Unzip mc-assignment-2.zip and import the project in any Android IDE. Build the project using Gradle.


## Compatibility

Cat-liker app is compatible from Android Lolipop to Android Pie version.

## Functionality

Cat-liker displays random cat pictures to the user and allows them to like or dislike as per their choice. 
Upon clicking the like/dislike button, a relevant counter is displayed on the screen. After the 10th like/dislike click, the user sees a cat picture on the final screen with a back button.

## App design

Cat-liker app follows minimalistic and intuitive design to keep the user experience simplistic.

A simple on-screen help feature is provided(top right on the screen) which can guide the user during the first or subsequent app use. This help button is accessible on all app screens.


## Architecture

Cat-liker follows Google's recommended single-activity architecture [1], It supports high cohesion, low coupling by following MVVM architecture [2]

- Main activity binds three fragments:  **StartFragment** , **ListFragment**, and **FinalFragment**
- Follows **Two-way binding** [3] which binds the UI component and functionality together. Any changes done on the UI component is captured by the appropriate listeners.


## Workflow

### 1) Home screen

![home screen](/project_resources/HomeScreen.png)

### 2) Cat view page with like and dislike button

![cat view screen](/project_resources/CatViewScreen.png)

### 3) Final screen with cat picture and back button.

![final screen](/project_resources/FinalScreen.png)

### 3) Help section.

![help screen](/project_resources/HelpScreen.png)


## References
[1] https://developer.android.com/jetpack/docs/guide

[2] https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel

[3] https://developer.android.com/topic/libraries/data-binding/two-way