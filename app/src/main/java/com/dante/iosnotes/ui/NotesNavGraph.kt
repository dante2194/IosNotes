package com.dante.iosnotes.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NotesNavGraph() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "list") {
        composable("list") {
            NotesListScreen(
                onNoteClick = { id -> nav.navigate("edit/$id") },
                onNewNote   = { nav.navigate("edit/0") }
            )
        }
        composable(
            route = "edit/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { entry ->
            val id = entry.arguments?.getLong("id") ?: 0L
            NoteEditScreen(noteId = id, onBack = { nav.popBackStack() })
        }
    }
}
