package com.geancarloleiva.jetcompnoteapp_12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.geancarloleiva.jetcompnoteapp_12.data.NoteDataSource
import com.geancarloleiva.jetcompnoteapp_12.model.Note
import com.geancarloleiva.jetcompnoteapp_12.screen.NoteScreen
import com.geancarloleiva.jetcompnoteapp_12.ui.theme.JetCompNoteApp_12Theme
import com.geancarloleiva.jetcompnoteapp_12.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //Identifies this class as dependency container
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCompNoteApp_12Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val noteViewModel: NoteViewModel by viewModels()
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()){
    val lstNote = noteViewModel.getAllNotes()

    NoteScreen(
        lstNote = lstNote,
        onAddNote = {
            noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetCompNoteApp_12Theme {
    }
}