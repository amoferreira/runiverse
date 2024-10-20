package com.amoferreira.core.presentation.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amoferreira.core.presentation.designsystem.RuniverseTheme

@Composable
fun OutlinedTextButton(
    modifier: Modifier = Modifier,
    text: String,
    isLoading: Boolean,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val alphaText = if (isLoading) 0f else 1f
    val alphaIndicator = if (isLoading) 1f else 0f
    val contentColor = MaterialTheme.colorScheme.onBackground
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor,
        ),
        border = BorderStroke(
            width = 0.5.dp,
            color = contentColor,
        ),
        shape = RoundedCornerShape(100f),
        modifier = modifier.height(IntrinsicSize.Min)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(15.dp)
                    .alpha(alphaIndicator),
                strokeWidth = 1.5.dp,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = text,
                modifier = Modifier.alpha(alphaText),
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Preview
@Composable
private fun TextButtonPreview() {
    RuniverseTheme {
        OutlinedTextButton(text = "Text for button", isLoading = false) {}
    }
}