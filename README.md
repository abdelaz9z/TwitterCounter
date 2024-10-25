# Twitter Counter Application

## Overview
The Twitter Counter application is a user-friendly component designed to help users count characters in a tweet while adhering to Twitter's character limit rules. This project showcases integration with the Twitter API for posting tweets and provides real-time character count feedback as users compose their messages.

## Features
- **Real-Time Character Count**: The UI component updates the character count dynamically as the user types.
- **Twitter API Integration**: Users can authenticate their Twitter accounts and post tweets directly from the application.
- **Modular Architecture**: The application is designed with clean architecture principles, promoting separation of concerns and enhancing maintainability.
- **Unit Testing**: Basic unit tests have been implemented to ensure the correctness of the main functionalities.

## Technical Stack
- **Android**: Built using Kotlin and Jetpack Compose for a modern UI experience.
- **Retrofit**: Used for making network requests to the Twitter API.
- **Coroutines**: Implemented for handling asynchronous operations.
- **Dagger Hilt**: For dependency injection, improving the modularity and testability of the application.
- **Secrets Management**: Sensitive information such as API keys are handled securely.

## Setup Instructions
To run this application, follow these steps:

1. **Add Twitter API Authentication**
   - Create a Twitter Developer account and set up a project to obtain your API keys.
   - Add your keys to the secrets file located at `TwitterCounter/secrets.defaults.properties`.

2. **Build and Run the Application**
   - Open the project in Android Studio.
   - Make sure to sync the Gradle files and build the project.
   - Run the application on an emulator or physical device.

## Usage
1. **Character Counting**: As you type in the text field, the character count will be displayed, updating in real-time.
2. **Posting Tweets**: After composing your tweet, tap the post button to send it to your Twitter account.

## API Documentation
### POST: Post Tweet
- **Endpoint**: `https://api.x.com/2/tweets`  
  Creates a Tweet on behalf of an authenticated user.

**Authorization**: OAuth 1.0  
- **Consumer Key**: `<consumer-key>`  
- **Consumer Secret**: `<consumer-secret>`  
- **Access Token**: `<token>`  
- **Token Secret**: `<token-secret>`  

**Body (JSON)**:
```json
{
  "text": "Integrate with Twitter SDK/API to actually post that tweet."
}
```

For more details on the Twitter API, refer to the official documentation from Developer X: [Twitter API Reference](https://developer.x.com/en/docs/x-api/tweets/manage-tweets/api-reference/post-tweets#tab1).
