package com.casecode.twittercounter.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casecode.twittercounter.ui.theme.ClearSkies
import com.casecode.twittercounter.ui.theme.TwitterCounterTheme

@Composable
fun SectionCharacters(
    title: String,
    characterCount: String,
    modifier: Modifier = Modifier,
    cardBackgroundColor: Color = MaterialTheme.colorScheme.surface,
    titleBackgroundColor: Color = ClearSkies,
    borderColor: Color = ClearSkies,
    width: Dp = 181.dp,
    height: Dp = 108.dp
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = cardBackgroundColor,
        ),
        border = BorderStroke(2.dp, borderColor),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.size(
            width = width,
            height = height
        ) // Allows customization of the size from outside
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Title section
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 14.sp, // If needed to override, otherwise use the default style
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp)
                    .background(color = titleBackgroundColor)
                    .wrapContentHeight(Alignment.CenterVertically)
            )

            // Character count section
            Text(
                text = characterCount,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp // If needed to override, otherwise use the default style
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Takes up the remaining space
                    .wrapContentHeight(Alignment.CenterVertically)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SectionCharactersPreview() {
    TwitterCounterTheme {
        SectionCharacters(
            title = "Characters Typed",
            characterCount = "0/280"
        )
    }
}
