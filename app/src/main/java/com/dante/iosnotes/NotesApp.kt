package com.dante.iosnotes

import android.app.Application
import com.dante.iosnotes.data.AppDatabase
import com.dante.iosnotes.data.NotesRepository

class NotesApp : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { NotesRepository(database.noteDao()) }
}
