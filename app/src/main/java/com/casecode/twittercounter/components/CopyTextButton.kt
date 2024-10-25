package com.casecode.twittercounter.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.casecode.twittercounter.R
import com.casecode.twittercounter.ui.theme.SesameStreetGreen

@Composable
fun CopyTextButton(tweet: String, onTextCopied: () -> Unit) {
    val context = LocalContext.current // Get current context
    val clipboardManager =
        remember { context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager }

    Button(
        onClick = {
            // Create a ClipData object to hold the text
            val clip = ClipData.newPlainText(context.getString(R.string.copied_text), tweet)
            clipboardManager.setPrimaryClip(clip) // Set the clip data to the clipboard

            onTextCopied()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = SesameStreetGreen,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        enabled = tweet.isNotEmpty(),
    ) {
        Text(text = stringResource(R.string.copy_text))
    }
}
