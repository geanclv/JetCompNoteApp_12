package com.geancarloleiva.jetcompnoteapp_12.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.geancarloleiva.jetcompnoteapp_12.data.NoteDataSource
import com.geancarloleiva.jetcompnoteapp_12.model.Note

class NoteViewModel: ViewModel() {

    private var lstNote = mutableStateListOf<Note>()

    init{
        lstNote.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note){
        lstNote.add(note)
    }

    fun removeNote(note: Note){
        lstNote.remove(note)
    }

    fun getAllNotes(): List<Note> {
        return lstNote
    }
}