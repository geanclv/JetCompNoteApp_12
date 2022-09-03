package com.geancarloleiva.jetcompnoteapp_12.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geancarloleiva.jetcompnoteapp_12.data.NoteDataSource
import com.geancarloleiva.jetcompnoteapp_12.model.Note
import com.geancarloleiva.jetcompnoteapp_12.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel //Noting this ViewModel is using Hilt
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    //Due to we are using Room, we will going to change the "mutableStateListOf" by "Flow"
    //private var lstNote = mutableStateListOf<Note>()
    private val privLstNote = MutableStateFlow<List<Note>>(emptyList()) //private state
    val lstNote = privLstNote.asStateFlow() //public state

    val note = MutableLiveData<Note>(null)

    init {
        //Code moved to getAllNotes()
        /*
        //Dispatchers.IO indicates that the method can use as many processes (threads) as possible (run in parallel)
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged()
                .collect() { listOfNotes ->
                    if (listOfNotes.isNullOrEmpty()) {
                        Log.d("Empty", "Empty Note's list")
                    } else {
                        privLstNote.value = listOfNotes
                    }
                }
        }
        */
        getAllNotes()
    }

    fun getAllNotes(){
        //Dispatchers.IO indicates that the method can use as many processes (threads) as possible (run in parallel)
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged()
                .collect() { listOfNotes ->
                    if (listOfNotes.isNullOrEmpty()) {
                        Log.d("Empty", "Empty Note's list")
                    } else {
                        privLstNote.value = listOfNotes
                    }
                }
        }
    }

    fun getNoteById(id: String) {
        viewModelScope.launch {
            note.postValue(noteRepository.getNoteById(id))
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }

    fun removeAllNotes() {
        viewModelScope.launch {
            noteRepository.deleteAllNotes()
        }
    }

    fun removeNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }
}