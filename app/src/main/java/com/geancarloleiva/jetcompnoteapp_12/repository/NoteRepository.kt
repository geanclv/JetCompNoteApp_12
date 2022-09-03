package com.geancarloleiva.jetcompnoteapp_12.repository

import com.geancarloleiva.jetcompnoteapp_12.data.NoteDatabaseDao
import com.geancarloleiva.jetcompnoteapp_12.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDao
) {

    fun getAllNotes(): Flow<List<Note>> {
        return noteDatabaseDao.getAllNotes().flowOn(Dispatchers.IO).conflate()
    }

    suspend fun getNoteById(id: String): Note {
        return noteDatabaseDao.getNoteById(id)
    }

    suspend fun addNote(note: Note) {
        noteDatabaseDao.addNote(note)
    }

    suspend fun updateNote(note: Note) {
        noteDatabaseDao.updateNote(note)
    }

    suspend fun deleteAllNotes(){
        noteDatabaseDao.deleteAllNotes()
    }

    suspend fun deleteNote(note: Note){
        noteDatabaseDao.removeNote(note)
    }
}