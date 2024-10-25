package com.casecode.twittercounter.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.casecode.twittercounter.R
import com.casecode.twittercounter.components.TwitterCharacterCountToolbar
import com.casecode.twittercounter.components.TwitterCharacterCountUI
import com.casecode.twittercounter.components.dialog.LoadingDialog
import com.casecode.twittercounter.ui.theme.TwitterCounterTheme

@Composable
fun TwitterCharacterCountScreen(
    twitterViewModel: TwitterViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    // Collect the tweet and post response state flows
    val tweet by twitterViewModel.tweetText.collectAsState()
    val postResponse by twitterViewModel.postResponse.collectAsState()
    val isPosting by twitterViewModel.isPosting.collectAsState()

    // Create a scaffold to hold the UI
    TwitterCharacterCountScreen(
        tweet = tweet,
        onTweetChange = { newTweet ->
            twitterViewModel.updateTweetText(newTweet)
        },
        onTextCopied = {
            // Handle the text copied action
            twitterViewModel.showPostResponse(R.string.copied)
        },
        onClear = {
            // Clear the tweet when button is clicked
            twitterViewModel.clearTweetText()
        },
        onPostTweet = {
            // Call the ViewModel to post the tweet
            twitterViewModel.updateTweetText(tweet)
            twitterViewModel.postTweet()
        },
        onArrowClick = { /* Handle the back action or navigation */ },
    )

    // Display the response message (optional)
    postResponse?.let {
        Toast.makeText(context, stringResource(it), Toast.LENGTH_SHORT).show()
        twitterViewModel.clearPostResponse()
    }

    // Display the LoadingDialog while posting
    LoadingDialog(
        isLoading = isPosting,
        dismissOnBackPress = false,
        dismissOnClickOutside = false
    )
}

@Composable
fun TwitterCharacterCountScreen(
    tweet: String,
    onTweetChange: (String) -> Unit,
    onClear: () -> Unit,
    onPostTweet: () -> Unit,
    onArrowClick: () -> Unit,
    onTextCopied: () -> Unit,
    characterLimit: Int = 280,
) {
    Scaffold(
        topBar = {
            TwitterCharacterCountToolbar(onArrowClick = onArrowClick)
        },
        content = { paddingValues ->
            TwitterCharacterCountUI(
                tweet = tweet,
                onTweetChange = onTweetChange,
                onClear = onClear,
                onPostTweet = onPostTweet,
                onTextCopied = onTextCopied,
                characterLimit = characterLimit,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TwitterCharacterCountUIPreview() {
    TwitterCounterTheme {
        TwitterCharacterCountScreen(
            tweet = "",
            onTweetChange = {},
            onClear = {},
            onPostTweet = {},
            onArrowClick = {},
            onTextCopied = {}
        )
    }
}