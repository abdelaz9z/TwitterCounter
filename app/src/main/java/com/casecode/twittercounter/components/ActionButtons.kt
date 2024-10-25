package com.casecode.twittercounter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.casecode.twittercounter.R
import com.casecode.twittercounter.ui.theme.UntamedRed

@Composable
fun ActionButtons(
    tweet: String,
    onClear: () -> Unit,
    onTextCopied: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CopyTextButton(tweet = tweet, onTextCopied)

        Button(
            onClick = onClear,
            colors = ButtonDefaults.buttonColors(
                containerColor = UntamedRed,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp),
            enabled = tweet.isNotEmpty(),
        ) {
            Text(text = stringResource(R.string.clear_text), color = Color.White)
        }
    }
}
