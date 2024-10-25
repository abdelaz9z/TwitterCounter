package com.casecode.twittercounter.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.casecode.twittercounter.R
import com.casecode.twittercounter.ui.theme.Democrat

@Composable
fun TwitterCharacterCountUI(
    tweet: String,
    onTweetChange: (String) -> Unit,
    onClear: () -> Unit,
    onPostTweet: () -> Unit,
    onTextCopied: () -> Unit,
    characterLimit: Int = 280,
    modifier: Modifier = Modifier
) {
    val remainingChars = characterLimit - tweet.length

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.twitter_logo),
            contentDescription = stringResource(R.string.twitter_logo),
            tint = Democrat // Use MaterialTheme color
        )

        Spacer(modifier = Modifier.height(16.dp))

        CharacterCountRow(tweet.length, characterLimit, remainingChars)

        Spacer(modifier = Modifier.height(24.dp))

        // Tweet input field
        TweetInputField(
            tweet = tweet,
            onTweetChange = onTweetChange,
            characterLimit = characterLimit
        )

        Spacer(modifier = Modifier.height(24.dp))

        ActionButtons(tweet = tweet, onClear = onClear, onTextCopied = onTextCopied)

        Spacer(modifier = Modifier.height(24.dp))

        PostTweetButton(tweet = tweet, remainingChars = remainingChars, onPostTweet = onPostTweet)
    }
}
