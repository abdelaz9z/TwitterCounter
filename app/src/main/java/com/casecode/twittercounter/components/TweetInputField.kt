package com.casecode.twittercounter.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.casecode.twittercounter.R

@Composable
fun TweetInputField(
    tweet: String,
    onTweetChange: (String) -> Unit,
    characterLimit: Int
) {
    OutlinedTextField(
        value = tweet,
        onValueChange = { newTweet ->
            if (newTweet.length <= characterLimit) {
                onTweetChange(newTweet)
            }
        },
        label = {
            Text(
                text = stringResource(
                    R.string.start_typing_you_can_enter_up_to_characters,
                    characterLimit
                ),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(239.dp),
    )
}
