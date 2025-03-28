package com.amoferreira.core.presentation.designsystem

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = RuniverseBlue,
    background = RuniverseBlack,
    surface = RuniverseDarkGray,
    secondary = RuniverseWhite,
    tertiary = RuniverseWhite,
    primaryContainer = RuniverseBlue30,
    onPrimary = RuniverseBlack,
    onBackground = RuniverseWhite,
    onSurface = RuniverseWhite,
    onSurfaceVariant = RuniverseGray,
    error = RuniverseRed,
)

@Composable
fun RuniverseTheme(
    content: @Composable () -> Unit,
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if(!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}