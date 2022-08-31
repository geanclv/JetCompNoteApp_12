package com.geancarloleiva.jetcompnoteapp_12.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geancarloleiva.jetcompnoteapp_12.model.Note

@Database(
    entities = [Note::class],
    version = 1, exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {

    /*
    * Room configuration
    * 1. Define the entities (model classes) with @Entity
    * 2. Define Database (this class)
    * 3. Create Dao interface
    * 4. Create functions for our DB operations
    * */

    abstract fun noteDato(): NoteDatabaseDao
}