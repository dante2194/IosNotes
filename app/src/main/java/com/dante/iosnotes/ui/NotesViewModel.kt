package com.dante.iosnotes.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dante.iosnotes.NotesApp
import com.dante.iosnotes.data.Note
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class NotesViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = (app as NotesApp).repository
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    val notes: StateFlow<List<Note>> = _query
        .flatMapLatest { q ->
            if (q.isBlank()) repo.getAllNotes() else repo.searchNotes(q)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun setQuery(q: String) { _query.value = q }

    fun save(note: Note, onDone: (Long) -> Unit = {}) = viewModelScope.launch {
        val id = if (note.id == 0L) repo.insert(note)
                 else { repo.update(note); note.id }
        onDone(id)
    }

    fun delete(note: Note) = viewModelScope.launch { repo.delete(note) }

    suspend fun get(id: Long): Note? = repo.getNote(id)
}
