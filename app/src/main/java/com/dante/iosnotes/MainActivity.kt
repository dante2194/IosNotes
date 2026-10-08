package com.dante.iosnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.dante.iosnotes.ui.NotesNavGraph
import com.dante.iosnotes.ui.theme.IosNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Force the entire app into RTL layout (Persian/Arabic friendly).
            // English characters inside text fields still render correctly
            // because their text direction is auto-detected per paragraph.
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                IosNotesTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NotesNavGraph()
                    }
                }
            }
        }
    }
}
