package com.dante.iosnotes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val IosYellow      = Color(0xFFFFCC00)
val IosYellowDark  = Color(0xFFFFD60A)
val IosBlue        = Color(0xFF007AFF)
val IosRed         = Color(0xFFFF3B30)
val IosGray        = Color(0xFF8E8E93)
val IosGrayLight   = Color(0xFFF2F2F7)
val IosGrayDark    = Color(0xFF1C1C1E)
val IosGrayDark2   = Color(0xFF2C2C2E)

private val LightColors = lightColorScheme(
    primary = IosYellow,
    onPrimary = Color.Black,
    secondary = IosBlue,
    onSecondary = Color.White,
    background = IosGrayLight,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    surfaceVariant = IosGrayLight,
    onSurfaceVariant = IosGray,
    error = IosRed,
    onError = Color.White
)

private val DarkColors = darkColorScheme(
    primary = IosYellowDark,
    onPrimary = Color.Black,
    secondary = IosBlue,
    onSecondary = Color.White,
    background = Color.Black,
    onBackground = Color.White,
    surface = IosGrayDark,
    onSurface = Color.White,
    surfaceVariant = IosGrayDark2,
    onSurfaceVariant = IosGray,
    error = IosRed,
    onError = Color.White
)

@Composable
fun IosNotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}
