package com.casecode.twittercounter.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.casecode.twittercounter.ui.screen.TwitterCharacterCountScreen
import com.casecode.twittercounter.ui.theme.TwitterCounterTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main entry point of the application, responsible for initializing the user interface
 * and setting up dependency injection with Dagger Hilt.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /**
     * Called when the activity is starting. This is where most initialization should go.
     * This method sets the content view to the [TwitterCharacterCountScreen]
     * and applies the [TwitterCounterTheme].
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     * being shut down, this Bundle contains the data it most recently supplied
     * in [onSaveInstanceState]. Otherwise, it is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Function to enable edge-to-edge display mode
        setContent {
            TwitterCounterTheme { // Apply the app theme
                TwitterCharacterCountScreen() // Set the main screen for the activity
            }
        }
    }
}
