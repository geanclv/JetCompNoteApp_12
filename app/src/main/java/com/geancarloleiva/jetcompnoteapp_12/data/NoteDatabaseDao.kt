package com.geancarloleiva.jetcompnoteapp_12.data

import androidx.compose.runtime.MutableState
import androidx.room.*
import com.geancarloleiva.jetcompnoteapp_12.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM tbl_note")
    fun getAllNotes(): Flow<List<Note>> //MutableState<List<Note>> : not works well with Room

    @Query("SELECT * FROM tbl_note WHERE id = :id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Query("DELETE FROM tbl_note")
    suspend fun deleteAllNotes()

    @Delete
    suspend fun removeNote(note: Note)
}