package com.casecode.twittercounter.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.casecode.twittercounter.R

@Composable
fun CharacterCountRow(
    tweetLength: Int,
    characterLimit: Int,
    remainingChars: Int
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        SectionCharacters(
            modifier = Modifier.weight(1f),
            title = stringResource(R.string.characters_typed),
            characterCount = "$tweetLength/$characterLimit"
        )
        Spacer(modifier = Modifier.width(20.dp))
        SectionCharacters(
            modifier = Modifier.weight(1f),
            title = stringResource(R.string.characters_remaining),
            characterCount = "$remainingChars"
        )
    }
}