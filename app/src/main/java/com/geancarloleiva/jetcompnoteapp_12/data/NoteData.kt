package com.geancarloleiva.jetcompnoteapp_12.data

import com.geancarloleiva.jetcompnoteapp_12.model.Note

class NoteDataSource {

    fun loadNotes(): List<Note>{
        return listOf(
            Note(title = "note 1", detail = "detail 1"),
            Note(title = "note 2", detail = "detail 2"),
            Note(title = "note 3", detail = "detail 3"),
            Note(title = "note 4", detail = "detail 4"),
            Note(title = "note 5", detail = "detail 5"),
            Note(title = "note 6", detail = "detail 6"),
            Note(title = "note 7", detail = "detail 7")
        )
    }
}