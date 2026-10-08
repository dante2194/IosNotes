package com.dante.iosnotes.data

import kotlinx.coroutines.flow.Flow

class NotesRepository(private val dao: NoteDao) {
    fun getAllNotes(): Flow<List<Note>> = dao.getAll()
    fun searchNotes(q: String): Flow<List<Note>> = dao.search(q)
    suspend fun getNote(id: Long): Note? = dao.getById(id)
    suspend fun insert(note: Note): Long = dao.insert(note)
    suspend fun update(note: Note) = dao.update(note)
    suspend fun delete(note: Note) = dao.delete(note)
}
