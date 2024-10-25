package com.casecode.twittercounter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.casecode.twittercounter.R
import com.casecode.twittercounter.ui.theme.TwitterCounterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwitterCharacterCountToolbar(
    onArrowClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center // Centers the text in the toolbar
            ) {
                Text(text = stringResource(R.string.twitter_character_count), style = MaterialTheme.typography.titleMedium)
            }
        },
        actions = {
            IconButton(onClick = onArrowClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Next arrow icon
                    contentDescription = stringResource(R.string.next)
                )
            }
        }
    )
}

@Preview
@Composable
fun TwitterCharacterCountToolbarPreview() {
    TwitterCounterTheme {
        TwitterCharacterCountToolbar(
            onArrowClick = {}
        )
    }
}
