package com.casecode.twittercounter.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casecode.twittercounter.R
import com.casecode.twittercounter.ui.theme.Democrat

@Composable
fun PostTweetButton(tweet: String, remainingChars: Int, onPostTweet: () -> Unit) {
    Button(
        onClick = onPostTweet,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        enabled = tweet.isNotEmpty() && remainingChars >= 0,
        colors = ButtonDefaults.buttonColors(
            containerColor = Democrat,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = stringResource(R.string.post_tweet), fontSize = 18.sp)
    }
}