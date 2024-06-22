
# BOTANIFY
![Botanify Banner](https://i.ibb.co.com/3RW3B45/AI-powered-application-that-simplifies-plant-care-for-you.png)


BOTANIFY is an AI-powered application that simplifies plant care for you.

[App Interface and Botanify APK](https://drive.google.com/drive/folders/1mWePPQ1Bz7_U-v4ceGk_qANU9d6QOQ9K?usp=sharing)

[App Backend](https://github.com/rfqagst/botanify_backend)


## Features
- **Plant Diagnosis**: AI technology for diagnosing plant pests and diseases.
- **Watering Reminder**: Never forget to water your plants.
- **Informative Articles**: Access to information across various categories.

## Platform
- **Android**

## Language
- **Kotlin**

## User Interface
- **Jetpack Compose**

## Libraries and Dependencies
- **Dagger Hilt**
- **Firebase Realtime Database**
- **Firebase Storage**
- **Firebase Authentication**
- **Alarm Manager**
- **TFLite**

---

## Installation and Setup

### Prerequisites
- Android Studio installed
- Firebase project set up
- Node.js installed
- Python installed
- MySQL installed and running

### Steps

#### Clone the repositories

1. Clone the main repository:
    ```bash
    git clone https://github.com/rfqagst/botanify.git
    ```
2. Clone the backend repository:
    ```bash
    git clone https://github.com/rfqagst/botanify_backend.git
    ```

#### Set up the Android application

1. Open the main project in Android Studio.
2. Sync the project with Gradle files.
3. Configure Firebase:
    - Add `google-services.json` to the `app` directory.
    - Enable Firebase Authentication, Realtime Database, and Storage in your Firebase project.
4. Build and run the application on your Android device or emulator.

#### Set up the MySQL database

1. Start MySQL on your computer.
2. Import the provided SQL dump into your MySQL database using the `botanify.sql` file:
    ```bash
    mysql -u your_username -p your_database_name < path_to_botanify.sql
    ```

#### Set up and run the MySQL backend

1. Navigate to the `botanify_mysql_backend` folder in the backend repository:
    ```bash
    cd botanify_backend/botanify_mysql_backend
    ```
2. Install the necessary dependencies:
    ```bash
    npm install
    ```
3. Start the MySQL backend server:
    ```bash
    node index.js
    ```

#### Set up and run the AI plant detection backend

1. Navigate to the `scan_plant_backend` folder in the backend repository:
    ```bash
    cd botanify_backend/scan_plant_backend
    ```
2. Install the necessary Python dependencies:
    ```bash
    pip install -r requirements.txt
    ```
3. Start the AI plant detection backend server:
    ```bash
    python app.py
    ```

Now your backend servers are running and your Android application should be able to interact with them.
